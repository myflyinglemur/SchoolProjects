import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This program searches creates a representation of a DNA sequence, which it
 * can compare to other DNA strands. It was created for CSC 143.
 * 
 * @author rachellowy
 * @version 7 Dec 2016
 *
 */

public class DNA {

	private final ArrayList<String> BASES = new ArrayList<String>();
	private final ArrayList<String> A_AMINOS = new ArrayList<String>();
	private final ArrayList<String> T_AMINOS = new ArrayList<String>();
	private final ArrayList<String> C_AMINOS = new ArrayList<String>();
	private final ArrayList<String> G_AMINOS = new ArrayList<String>();

	private String dna;
	private File geneticCode;
	private boolean hasAmino;

	/**
	 * Constructs a Gene object from file info
	 * 
	 * @param gene
	 *            file with genetic info
	 * @param amino
	 *            true if file encodes amino acid codes
	 * @precondition: Gene file does not contain any letters aside from genetic
	 *                information (FASTA bases and amino codes only)
	 */
	public DNA(File geneticCode, boolean amino) throws FileNotFoundException {
		this.geneticCode = geneticCode;
		this.hasAmino = amino;
		this.dna = "";
		mapDNA();
		loadAminos();

		// loads FASTA codes for DNA bases and amino translations for each base
		loadBases();
		loadAminos();
	}

	/**
	 * Adds DNA base codes to base database
	 */
	private void loadBases() {
		BASES.add("A");
		BASES.add("T");
		BASES.add("C");
		BASES.add("G");
	}

	/**
	 * Adds amino translations for each of the base codes
	 */
	private void loadAminos() {
		// Amino codes where 'A' can be used
		A_AMINOS.add("M");
		A_AMINOS.add("R");
		A_AMINOS.add("W");
		A_AMINOS.add("V");
		A_AMINOS.add("H");
		A_AMINOS.add("D");
		A_AMINOS.add("N");

		// Amino codes where 'T' can be used
		T_AMINOS.add("W");
		T_AMINOS.add("Y");
		T_AMINOS.add("K");
		T_AMINOS.add("H");
		T_AMINOS.add("D");
		T_AMINOS.add("B");
		T_AMINOS.add("N");

		// Amino codes where 'C' can be used
		C_AMINOS.add("S");
		C_AMINOS.add("Y");
		C_AMINOS.add("V");
		C_AMINOS.add("H");
		C_AMINOS.add("B");
		C_AMINOS.add("N");

		// Amino codes where 'G' can be used
		G_AMINOS.add("R");
		G_AMINOS.add("S");
		G_AMINOS.add("K");
		G_AMINOS.add("V");
		G_AMINOS.add("D");
		G_AMINOS.add("B");
		G_AMINOS.add("N");
	}

	public void mapDNA() throws FileNotFoundException {
		Scanner fileReader = new Scanner(geneticCode);

		while (fileReader.hasNextLine()) {
			this.dna += fileReader.nextLine();
		}

		fileReader.close();

	}

	/**
	 * Gets DNA code
	 * 
	 * @return DNA code sequence
	 */
	public String getDNA() {
		return this.dna;
	}

	/**
	 * Gets length of this DNA code sequence
	 * 
	 * @return length of DNA sequence
	 */
	public int getSize() {
		return this.dna.length();
	}

	/**
	 * States whether this DNA code slice contains a DNA gene sequence; if one
	 * DNA piece contains aminos and the other does not, the program checks the
	 * amino against acceptable bases in the non-amino DNA.
	 * 
	 * Amino code substitution information:
	 * https://www.ncbi.nlm.nih.gov/staff/tao/tools/tool_lettercode.html
	 * 
	 * @return true of this DNA is contained in another
	 */
	public boolean contains(DNA gene) {
		boolean matchFound = false;
		boolean sameFASTA = this.hasAmino == gene.hasAmino;

		// only searches for gene in DNA collections larger than the gene
		if (this.getSize() < gene.getSize()) {
			matchFound = false;

		} else {

			int dnaIndex = 0;

			// continues loop while there are enough letters available to find a
			// match between this and gene of interest
			while (!matchFound && this.getSize() - dnaIndex >= gene.getSize()) {
				boolean keepSearching = true;

				// restarts at beginning of gene of interest's code each time
				// the starting dna index advances
				int geneIndex = 0;

				// continues searching while all letters are matches and there
				// are letters remaining in this dna sequence
				while (keepSearching && dnaIndex + geneIndex < this.getSize()) {
					char thisCode = this.getDNA().charAt(dnaIndex + geneIndex);
					char geneCode = gene.getDNA().charAt(geneIndex);

					//skips "N" codes in the DNA sequence being examined
					if (thisCode != 'N') {

						if (!BASES.contains(geneCode)) {

							// check to see if the geneCode is inside of
							// thisCode's amino chart;
							// if yes:
							// change geneCode to equal thisCode

						}

						// checks for equality between these letter codes and
						// determines whether to keep searching
						if (thisCode == geneCode) {

							if (geneIndex == gene.getSize() - 1) {
								// stops search; gene has been found
								keepSearching = false;
								matchFound = true;
							} else {
								// compares next FASTA codes
								geneIndex += 1;
							}
						} else {

							// stops search; conflict found
							keepSearching = false;
						}
					}
				}

				// advances to next index
				dnaIndex += 1;
			}

		}

		return matchFound;
	}

	/**
	 * Finds whether a base can be use interchangeably with a given amino
	 * 
	 * @param thisCode
	 * @param geneCode
	 * @return
	 */
	public boolean isAmino(DNA thisCode, DNA geneCode) {
		boolean same = true;
		
		return same;
	}
	
	/**
	 * Returns formatted DNA code
	 * 
	 * @return DNA code sequence
	 */
	@Override
	public String toString() {
		// TODO: format this in rows of 110 letters
		return getDNA();
	}

}
