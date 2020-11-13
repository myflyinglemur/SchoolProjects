import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Generates collections of DNA Sequences, similar to a species’ genome. Each
 * DNA collection has a 10% chance of containing specified gene sequence. The
 * program then searches each generated file until a copy of the gene is found.
 *
 * @author rachellowy
 * @version 12 Dec 2016
 *
 */

public class FindGeneratedDNA {

	// probability gene will be embedded into generated dna file
	public static final double GENE_PROB = 0.10;

	// upper bound of numbers in a dna directory
	public static final int numFile = 10;

	public static void main(String[] args) throws FileNotFoundException {
		Random r = new Random();

		// List for dna collections with/without gene
		ArrayList<String> hasGene = new ArrayList<String>();
		ArrayList<String> doesNotHaveGene = new ArrayList<String>();

		// gene info and Files
		File geneDir = new File("geneFiles");
		geneDir.mkdir();
		File gene1 = new File("geneFiles/gene1.txt");
		PrintStream geneWriter = new PrintStream(gene1);
		DNA gene1Code = new DNA(new File("GeneAsAmino.txt"));
		boolean geneIsAmino = true;
		geneWriter.append(gene1Code.getDNA());

		// DNA files
		File dnaDir = new File("dnaDir1");
		dnaDir.mkdir();
		String dnaDirName = dnaDir.getName();

		// builds a file directory of randomly generated DNA files which may
		// contain gene1
		buildDir(r, r.nextInt(numFile) + 1, dnaDirName, gene1Code, geneIsAmino);

		GeneFinder geneFinder = new GeneFinder(dnaDirName, listDirectory(dnaDir), listDirectory(geneDir), geneIsAmino);

		int location = geneFinder.findGene();
		addToList(dnaDir.listFiles(), location, hasGene, doesNotHaveGene);

		// prints search results
		System.out.println("\nSEARCH RESULTS \nGene Found:");
		for (int i = 0; i < hasGene.size(); i++) {
			System.out.println(dnaDir.getName() + " " + hasGene.get(i));
		}

		System.out.println("\nGene not found:");
		for (int i = 0; i < doesNotHaveGene.size(); i++) {
			System.out.println(dnaDir.getName() + " " + doesNotHaveGene.get(i));
		}

		geneWriter.close();
	}

	/**
	 * Generates DNA files to fill a directory
	 * 
	 * @param dirSize
	 *            number of files to put in directory
	 * @param dirName
	 *            name of director to write files to
	 * @param geneCode
	 *            genetic code to search for
	 * @throw FileNotFoudException
	 */
	public static void buildDir(Random r, int dirSize, String dirName, DNA geneCode, boolean isAmino)
			throws FileNotFoundException {
		for (int i = 0; i < dirSize; i++) {
			String dnaFilePath = dirName + "/File" + i + ".txt";
			File dnaFile = new File(dnaFilePath);
			PrintStream dnaWriter = new PrintStream(dnaFile);

			Double genePresent = r.nextDouble();
			if (genePresent < GENE_PROB) {
				String dna = geneCode.getDNA();
				dnaWriter.append(new DNAGenerator(dna, isAmino).getDNA());
				System.out.println("Gene Expected in " + i);

			} else {
				dnaWriter.append(new DNAGenerator().getDNA());
				System.out.println("Gene Not Expected in " + i);
			}

			dnaWriter.close();
		}
	}

	/**
	 * Adds genome to appropriate list, based on whether gene is found
	 * 
	 * @param directory
	 *            list of all DNA files for species
	 * @param location
	 *            location of gene
	 * @param gene
	 *            list of DNA directories with gene
	 * @param gene
	 *            list of DNA directories without gene
	 */
	public static void addToList(File[] directory, int location, ArrayList<String> gene, ArrayList<String> noGene) {
		if (location < 0) {
			noGene.add("not found");
		} else {
			gene.add("location: " + directory[location]);
		}
	}

	/**
	 * Creates directory array for species DNA files
	 * 
	 * @param dnaFiles
	 *            directory of DNA files
	 */
	public static File[] listDirectory(File dnaFiles) {
		File[] allDNA = dnaFiles.listFiles(new FilenameFilter() {

			// ignores DS_Store files (mac) - not original; credit in intro
			@Override
			public boolean accept(File dir, String name) {
				return !name.equals(".DS_Store");
			}
		});

		return allDNA;
	}
}
