import java.io.File;
import java.io.FileNotFoundException;

/**
 * Finds any one of a collection of gene isoforms inside of collection of DNA
 * files in FASTA format. It was created for CSC 143 at South Seattle College.
 * 
 * @author rachellowy
 * @version 13 Dec 2017
 */

public class GeneFinder {

	/*
	 * PRIVATE VARS
	 */

	String dnaName;
	private File[] dnaFiles;
	private File[] geneFiles;
	private boolean geneIsAmino;

	/**
	 * Constructor
	 * 
	 * @param dnaCollection
	 *            collection of files holding DNA
	 * @param dnaFiles
	 *            directory will all DNA files to search through
	 * @param geneFiles
	 *            directory with all gene isoforms to look through
	 * @param geneIsAmino
	 *            true if gene is composed of amino acid codes; false otherwise
	 */
	public GeneFinder(String dnaName, File[] dnaFiles, File[] geneFiles, boolean geneIsAmino) {
		this.dnaName = dnaName;
		this.dnaFiles = dnaFiles;
		this.geneFiles = geneFiles;
		this.geneIsAmino = geneIsAmino;
	}

	/**
	 * Searches for gene in a collection of dnaFiles
	 * 
	 * @return location of file with gene in a directory
	 * @throws FileNotFoundException
	 */
	public int findGene() throws FileNotFoundException {
		System.out.println("\nSearching " + this.dnaName);

		boolean geneLocated = false;
		int dnaIndex = 0;
		int geneLocation = -1;

		// searches until gene found or no more DNA
		while (!geneLocated && dnaIndex < this.dnaFiles.length) {
			DNA dna = new DNA(this.dnaFiles[dnaIndex]);

			int geneIndex = 0;

			// searches this DNA for all isoforms until a match is found
			while (!geneLocated && geneIndex < this.geneFiles.length) {
				DNA gene = new DNA(this.geneFiles[geneIndex]);

				geneLocated = dna.contains(gene, geneIsAmino);

				if (geneLocated) {
					geneLocation = dnaIndex;
				} else {
					geneIndex += 1;

					// visual search feedback; assumes partial matches exist
					if (geneIndex % 2 == 0) {
						System.out.print(".");
					}

				}

			}

			// advances search
			dnaIndex += 1;
		}

		return geneLocation;

	}

	/**
	 * Returns name of dnaFiles being searched
	 */
	@Override
	public String toString() {
		return this.dnaName + " Gene Finder";
	}
}
