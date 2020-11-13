import java.util.Random;

/**
 * Generates DNA Sequences. Can generate with or without specific genes
 * 
 * @author rachellowy
 * @version 12 Dec 2016
 *
 */

public class DNAGenerator {

	// Nucleotide base codes
	private static final String[] BASES = { "A", "C", "T", "G" };

	// Codon length; based on scientific findings
	private static final int CODON_LENGTH = 3;

	// lower and upper bound for random numbers
	// actual DNA bound lengeths will be 3 times larger than these number
	// because of codon length
	private static final int LOWER = 15;
	private static final int UPPER = 30;

	// DNA info
	private String embeddedDNA = "";
	private String dna = "";
	private Random r = new Random();
	private AminoDictionary aminoDict = new AminoDictionary();

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * Basic Constructor Produce DNA String of length 90 - 300 characters long
	 * without any special sequence embedded
	 */
	public DNAGenerator() {
		this("", false);
	}

	/**
	 * Full Constructor; Contains specified sequence to embed Produce DNA with
	 * special sequence embedded 90 - 300 additional characters
	 * 
	 * @param dna
	 *            generates code with this dna sequence embedded in it
	 */
	public DNAGenerator(String toEmbed, boolean hasAminos) {
		setEmbeddedDNA(toEmbed, hasAminos);
		generateDNA();
	}

	/*
	 * ACCESSORS
	 */

	/**
	 * Returns embedded DNA string
	 * 
	 * @return embedded DNA string
	 */
	public String getEmbedded() {
		String dna = "";

		if (this.embeddedDNA != "") {
			dna += this.embeddedDNA;
		} else {
			dna += "No embedded DNA; Sequence is random";
		}

		return dna;
	}

	/**
	 * Returns full DNA sequence
	 * 
	 * @return full DNA sequence
	 */
	public String getDNA() {
		return this.dna;
	}

	/*
	 * MUTATORS
	 */
	
	/**
	 * Sets embedded DNA to a given sequence
	 * 
	 * @param dna
	 *            sequence to be embedded in code
	 * @param isAmino
	 *            true if the sequence is amino codes, false otherwise
	 */
	public void setEmbeddedDNA(String dna, boolean isAmino) {
		if (isAmino) {
			this.embeddedDNA = aminoDict.translateAminoString(dna);
		} else {
			this.embeddedDNA = dna;
		}

	}

	/*
	 * OTHER METHODS
	 */
	/**
	 * Generates a new string of dna which randomly decides how long it should
	 * be based on provided bounds
	 */
	public void generateDNA() {
		// generates random number of codons
		int sequenceLength = (r.nextInt(UPPER - LOWER) + LOWER) * 3;
		int embedAt = r.nextInt(sequenceLength);

		for (int i = 0; i < sequenceLength; i++) {
			int count = 0;
			while (count < CODON_LENGTH) {
				this.dna += BASES[r.nextInt(BASES.length)];
				count += 1;
			}

			if (i == embedAt) {
				this.dna += this.embeddedDNA;
			}

		}
	}

	/**
	 * Returns full DNA sequence of generated gene
	 * 
	 * @return full DNA sequence of generated gene
	 */
	@Override
	public String toString() {
		return this.dna;
	}

}
