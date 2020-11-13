import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This program searches creates a representation of a DNA sequence, which it
 * can compare to other DNA strands. It was created for CSC 143 at South Seattle
 * College.
 * 
 * @author rachellowy
 * @version 7 Dec 2016
 *
 */

public class DNA {

	private static final int CODON_LENGTH = 3;

	private String dna;
	private File geneticCode;

	/*
	 * CONSTRUCTOR
	 */

	/**
	 * Constructs a Gene object from file info
	 * 
	 * @param gene
	 *            file with genetic info
	 * @precondition: Gene file does not contain any letters aside from genetic
	 *                information (FASTA bases and amino codes only)
	 */
	public DNA(File geneticCode) throws FileNotFoundException {
		this.geneticCode = geneticCode;
		this.dna = "";
		mapDNA();
	}

	/**
	 * Stores FASTA sequence in this DNA object
	 * 
	 * @throws FileNotFoundException
	 */
	public void mapDNA() throws FileNotFoundException {
		Scanner fileReader = new Scanner(geneticCode);

		while (fileReader.hasNextLine()) {
			this.dna += fileReader.nextLine();
		}

		fileReader.close();

	}

	/*
	 * ACCESSORS
	 */

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
	 * Gets a codon (3 letter base sequence) starting at given index
	 * 
	 * @param index
	 *            index at which to start search
	 * @return 3-letter codon sequence
	 * @throws IllegalArgumentException
	 *             if fewer than 3 bases remain in sequence
	 * @precondition: dna has three or more letters remaining
	 */
	public String getCodon(int index) {
		if (this.getSize() < index + 3) {
			throw new IllegalArgumentException("Insufficient DNA to create codon");
		}

		String codon = this.dna.substring(index, index + 3);

		return codon;
	}

	/*
	 * MUTATORS
	 */

	/**
	 * Sets DNA to specified string
	 * 
	 * @param dna
	 *            genetic code to assign to this dna object
	 */
	public void setDNA(String dna) {
		this.dna = dna;
	}

	/*
	 * OTHER METHODS
	 */

	/**
	 * States whether this DNA slice contains a gene's genetic sequence; if one
	 * DNA piece contains aminos and the other does not, the program checks the
	 * amino against acceptable bases in the non-amino DNA.
	 * 
	 * @return true of this DNA sequences contains another DNA sequence
	 */
	public boolean contains(DNA gene, boolean geneIsAmino) {
		int geneIncrement = 1;
		if (!geneIsAmino) {
			geneIncrement = CODON_LENGTH;
		}

		boolean matchFound = false;

		// only searches for gene in DNA collections larger than the gene
		if (this.getSize() < gene.getSize()) {
			matchFound = false;

		} else {

			int dnaStartIndex = 0;

			// runs if match not yet found and DNA is long enough to contain
			// gene
			while (!matchFound && (this.getSize() - dnaStartIndex) >= gene.getSize()) {
				boolean keepSearching = true;

				// starts search at beginning of gene's code
				int geneIndex = 0;

				// runs while gene match found so far and there is enough DNA to
				// make codon
				while (keepSearching && dnaStartIndex + geneIndex <= this.getSize() + CODON_LENGTH) {

					// skips unspecified regions of DNA
					if (this.getDNA().charAt(dnaStartIndex + geneIndex) == 'N') {
						keepSearching = false;

					} else {

						// gets 3-letter codon based on DNA and gene indexes
						String dnaCodon = getCodon(dnaStartIndex + geneIndex);

						// searches by codon once a single match is found
						if (geneIndex > 0) {
							dnaCodon = getCodon(dnaStartIndex + geneIndex * CODON_LENGTH);
						}

						boolean codesAreEqual;
						if (geneIsAmino) {
							// gets amino single letter code
							String geneAmino = gene.getDNA().substring(geneIndex, geneIndex + 1);

							// looks up codons that make amino
							AminoDictionary aminoDict = new AminoDictionary();
							ArrayList<String> aminoCodons = aminoDict.get(geneAmino);

							// determines whether codons and protein are
							// equivalent
							codesAreEqual = aminoCodons.contains(dnaCodon);
						} else {
							String geneCodon = gene.getCodon(geneIndex);
							codesAreEqual = geneCodon.equals(dnaCodon);
						}
						// checks equality of codon and gene
						if (codesAreEqual) {

							if (geneIndex == gene.getSize() - geneIncrement) {

								// stops search if entire gene has been found
								keepSearching = false;
								matchFound = true;

							} else {

								// advances search
								geneIndex += geneIncrement;

							}
						} else {

							// stops search; conflict found
							keepSearching = false;
						}
					}
				}

				// re-starts search at next letter code in DNA sequence
				dnaStartIndex += 1;
			}
		}
		return matchFound;
	}

	/**
	 * Checks for equality between a codon sequence and an amino
	 * 
	 * @param amino
	 *            single letter amino acid code
	 * @return true if codon is acceptable amino sequence, false otherwise
	 * @precondition: amino is a valid amino acid
	 */
	public ArrayList<String> getValidCodons(String amino) {
		AminoDictionary aminoDict = new AminoDictionary();

		return aminoDict.get(amino);

	}

	/**
	 * Returns formatted DNA code
	 * 
	 * @return DNA code sequence
	 */
	@Override
	public String toString() {
		return this.dna;
	}

}
