import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * This program searches for the INDY gene in various fruit flies species. It
 * was created for CSC 143 at South Seattle College.
 * 
 * Credit for ignore DS file code: StackOverflow user MadConan accessed 10 Dec
 * 2016: http://stackoverflow.com/questions/30486404/
 * 
 * @author rachellowy
 * @version 7 Dec 2016
 *
 */

public class FindINDY {

	// Welcomes user and searches for DNA
	public static void main(String[] args) throws FileNotFoundException {

		// directory and info for gene isoforms
		File[] isoforms = listDirectory(new File("../Genomes/geneINDY"));
		boolean geneIsAmino = true;

		// List for species with/without gene
		ArrayList<String> hasGene = new ArrayList<String>();
		ArrayList<String> doesNotHaveGene = new ArrayList<String>();

		// search genome files and adds genome to appropriate list
		searchGenome("melagonster", listDirectory(new File("../Genomes/melagonster/melagonsterDNA")), isoforms,
				geneIsAmino, hasGene, doesNotHaveGene);

		searchGenome("ananassae", listDirectory(new File("../Genomes/ananassae/ananassaeDNA")), isoforms, geneIsAmino,
				hasGene, doesNotHaveGene);

		searchGenome("erecta", listDirectory(new File("../Genomes/erecta/erectaDNA")), isoforms, geneIsAmino, hasGene,
				doesNotHaveGene);

		searchGenome("grimshawi", listDirectory(new File("../Genomes/grimshawi/grimshawiDNA")), isoforms, geneIsAmino,
				hasGene, doesNotHaveGene);

		searchGenome("mojavensis", listDirectory(new File("../Genomes/mojavensis/mojavensisDNA")), isoforms,
				geneIsAmino, hasGene, doesNotHaveGene);

		searchGenome("persimilis", listDirectory(new File("../Genomes/persimilis/persimilisDNA")), isoforms,
				geneIsAmino, hasGene, doesNotHaveGene);

		searchGenome("pseudoobscura", listDirectory(new File("../Genomes/pseudoobscura/pseudoobscuraDNA")), isoforms,
				geneIsAmino, hasGene, doesNotHaveGene);

		searchGenome("sechellia", listDirectory(new File("../Genomes/sechellia/sechelliaDNA")), isoforms, geneIsAmino,
				hasGene, doesNotHaveGene);

		searchGenome("simulans", listDirectory(new File("../Genomes/simulans/simulansDNA")), isoforms, geneIsAmino,
				hasGene, doesNotHaveGene);

		searchGenome("virilis", listDirectory(new File("../Genomes/virilis/virilisDNA")), isoforms, geneIsAmino,
				hasGene, doesNotHaveGene);

		searchGenome("willistoni", listDirectory(new File("../Genomes/willistoni/willistoniDNA")), isoforms,
				geneIsAmino, hasGene, doesNotHaveGene);

		searchGenome("yakuba", listDirectory(new File("../Genomes/yakuba/yakubaDNA")), isoforms, geneIsAmino, hasGene,
				doesNotHaveGene);

		// Print out list of species with/without genome
		System.out.println("\nSEARCH RESULTS \nSpecies with Gene:");
		for (int i = 0; i < hasGene.size(); i++) {
			System.out.println(hasGene.get(i));
		}

		System.out.println("\nSpecies without Gene:");
		for (int i = 0; i < doesNotHaveGene.size(); i++) {
			System.out.println(doesNotHaveGene.get(i));
		}
	}

	/**
	 * Searches genome file collection for isoforms of a gene and adds species
	 * name to appropriate list
	 * 
	 * @param speciesName
	 *            Name of species being searched
	 * @param genome
	 *            Location of genome files
	 * @param isoforms
	 *            Location of isoforms of gene of interest
	 * @param isAmino
	 *            True if gene of interest is in amino code; false otherwise
	 * @param hasGene
	 *            ArrayList to hold genomes with gene of interest
	 * @param noGene
	 *            ArrayList to hold genomes without gene of interest
	 * 
	 * @throw FileNotFoundException
	 */
	public static void searchGenome(String speciesName, File[] genome, File[] isoforms, boolean isAmino,
			ArrayList<String> hasGene, ArrayList<String> noGene) throws FileNotFoundException {
		GeneFinder geneCrawler = new GeneFinder(speciesName, genome, isoforms, isAmino);
		int location = geneCrawler.findGene();
		addToList(speciesName, genome, location, hasGene, noGene);
	}

	/**
	 * Adds genome to appropriate list, based on whether gene is found
	 * 
	 * @param species
	 *            species recently searched
	 * @param directory
	 *            list of all DNA files for species
	 * @param location
	 *            location of gene
	 * @param gene
	 *            list of species where gene was found
	 * @param noGene
	 *            list of species where gene was not found
	 */
	public static void addToList(String species, File[] directory, int location, ArrayList<String> gene,
			ArrayList<String> noGene) {
		if (location < 0) {
			noGene.add(species);
		} else {
			gene.add(species + "\t\t" + directory[location]);
		}
	}

	/**
	 * Creates directory array for species DNA files
	 * 
	 * @param speciesFiles
	 *            directory of DNA files for a species
	 */
	public static File[] listDirectory(File speciesFiles) {
		File[] speciesDNA = speciesFiles.listFiles(new FilenameFilter() {

			// ignores DS_Store files (mac) - not original; credit in intro
			@Override
			public boolean accept(File dir, String name) {
				return !name.equals(".DS_Store");
			}
		});

		return speciesDNA;
	}

}
