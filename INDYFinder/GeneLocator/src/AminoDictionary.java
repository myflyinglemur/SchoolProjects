import java.util.ArrayList;
import java.util.Random;

/**
 * Stores codon sequences that make up each of 20 amino acids in the body.
 * 
 * Amino acid dictionary data was obtained from the National Center for
 * Biotechnology Information (a sub-division of the National Institute of
 * Health) accessed 12/2016
 * https://www.ncbi.nlm.nih.gov/staff/tao/tools/tool_lettercode.html
 * 
 * 
 * @author rachellowy
 * @version 7 Dec 2016
 *
 */

public class AminoDictionary {

	/*
	 * PRIVATE VARIABLES
	 */
	private final ArrayList<String> I = new ArrayList<String>();
	private final ArrayList<String> L = new ArrayList<String>();
	private final ArrayList<String> V = new ArrayList<String>();
	private final ArrayList<String> F = new ArrayList<String>();
	private final ArrayList<String> M = new ArrayList<String>();
	private final ArrayList<String> C = new ArrayList<String>();
	private final ArrayList<String> A = new ArrayList<String>();
	private final ArrayList<String> G = new ArrayList<String>();
	private final ArrayList<String> P = new ArrayList<String>();
	private final ArrayList<String> T = new ArrayList<String>();
	private final ArrayList<String> S = new ArrayList<String>();
	private final ArrayList<String> Y = new ArrayList<String>();
	private final ArrayList<String> W = new ArrayList<String>();
	private final ArrayList<String> Q = new ArrayList<String>();
	private final ArrayList<String> N = new ArrayList<String>();
	private final ArrayList<String> H = new ArrayList<String>();
	private final ArrayList<String> E = new ArrayList<String>();
	private final ArrayList<String> D = new ArrayList<String>();
	private final ArrayList<String> K = new ArrayList<String>();
	private final ArrayList<String> R = new ArrayList<String>();
	private final ArrayList<String> Stop = new ArrayList<String>();

	/**
	 * Creates new dictionary object
	 */
	public AminoDictionary() {
	}

	/**
	 * Gets equivalency list for an amino. Includes all 20 accepted amino acids
	 * plus 'stop' codes.
	 * 
	 * @param amino
	 *            amino acid single letter code (or '*' for stop codes)
	 * @return arraylist with amino acid equivalents
	 * @throws IllegalArgumentException
	 *             if given illegal amino acid
	 * @precondition 'amino' is a valid single letter amino code
	 */
	public ArrayList<String> get(String amino) {
		ArrayList<String> list;

		if (amino.equals("I")) 			{	loadI();	list = this.I;
		} else if (amino.equals("L")) 	{	loadL();	list = this.L;
		} else if (amino.equals("V")) 	{	loadV();	list = this.V;
		} else if (amino.equals("F")) 	{	loadF();	list = this.F;
		} else if (amino.equals("M")) 	{	loadM();	list = this.M;
		} else if (amino.equals("C")) 	{	loadC();	list = this.C;
		} else if (amino.equals("A")) 	{	loadA();	list = this.A;
		} else if (amino.equals("G")) 	{	loadG();	list = this.G;
		} else if (amino.equals("P")) 	{	loadP();	list = this.P;
		} else if (amino.equals("T")) 	{	loadT();	list = this.T;
		} else if (amino.equals("S")) 	{	loadS();	list = this.S;
		} else if (amino.equals("Y")) 	{	loadY();	list = this.Y;
		} else if (amino.equals("W")) 	{	loadW();	list = this.W;
		} else if (amino.equals("Q")) 	{	loadQ();	list = this.Q;
		} else if (amino.equals("N")) 	{	loadN();	list = this.N;
		} else if (amino.equals("H")) 	{	loadH();	list = this.H;
		} else if (amino.equals("E")) 	{	loadE();	list = this.E;
		} else if (amino.equals("D")) 	{	loadD();	list = this.D;
		} else if (amino.equals("K")) 	{	loadK();	list = this.K;
		} else if (amino.equals("R")) 	{	loadR();	list = this.R;
		} else if (amino.equals("*")) 	{	loadStop();	list = this.Stop;
		} else {
			throw new IllegalArgumentException("Not a valid amino acid");
		}

		return list;
	}

	/**
	 * Loads codons for A amino
	 */
	public void loadA() {
		A.add("GCT");
		A.add("GCC");
		A.add("GCA");
		A.add("GCG");
	}

	/**
	 * Loads codons for C amino
	 */
	public void loadC() {
		// C codons;
		C.add("TGT");
		C.add("TGC");
	}

	/**
	 * Loads codons for D amino
	 */
	public void loadD() {
		// D codons
		D.add("GAT");
		D.add("GAC");
	}

	/**
	 * Loads codons for E amino
	 */
	public void loadE() {
		// E codons
		E.add("GAA");
		E.add("GAG");
	}

	/**
	 * Loads codons for F amino
	 */
	public void loadF() {
		// F codons
		F.add("TTT");
		F.add("TTC");
	}

	/**
	 * Loads codons for G amino
	 */
	public void loadG() {
		// G codons
		G.add("GGT");
		G.add("GCC");
		G.add("GGA");
		G.add("GGG");
	}

	/**
	 * Loads codons for H amino
	 */
	public void loadH() {
		// H codons
		H.add("CAT");
		H.add("CAC");
	}

	/**
	 * Loads codons for I amino
	 */
	public void loadI() {
		// I codons
		I.add("ATT");
		I.add("ATC");
		I.add("ATA");
	}

	/**
	 * Loads codons for K amino
	 */
	public void loadK() {
		// K codons
		K.add("AAA");
		K.add("AAG");
	}

	/**
	 * Loads codons for L amino
	 */
	public void loadL() {
		// L codons
		L.add("CTT");
		L.add("CTC");
		L.add("CTA");
		L.add("CTG");
		L.add("TTA");
		L.add("TTG");
	}

	/**
	 * Loads codons for M amino
	 */
	public void loadM() {
		// M codons
		M.add("ATG");
	}

	/**
	 * Loads codons for N amino
	 */
	public void loadN() {
		// N codons
		N.add("AAT");
		N.add("AAC");
	}

	/**
	 * Loads codons for P amino
	 */
	public void loadP() {
		// P codons
		P.add("CCT");
		P.add("CCC");
		P.add("CCA");
		P.add("CCG");
	}

	/**
	 * Loads codons for Q amino
	 */
	public void loadQ() {
		// Q codons
		Q.add("CAA");
		Q.add("CAG");
	}

	/**
	 * Loads codons for R amino
	 */
	public void loadR() {
		// R codons
		R.add("CGT");
		R.add("CGC");
		R.add("CGA");
		R.add("CGG");
		R.add("AGA");
		R.add("AGG");
	}

	/**
	 * Loads codons for S amino
	 */
	public void loadS() {
		// S codons
		S.add("TCT");
		S.add("TCC");
		S.add("TCA");
		S.add("TCG");
		S.add("AGT");
		S.add("AGC");
	}

	/**
	 * Loads codons for T amino
	 */
	public void loadT() {
		// T codons
		T.add("ACT");
		T.add("ACC");
		T.add("ACA");
		T.add("ACG");
	}

	/**
	 * Loads codons for V amino
	 */
	public void loadV() {
		// V codons
		V.add("GTT");
		V.add("GTC");
		V.add("GTA");
		V.add("GTG");
	}

	/**
	 * Loads codons for Y amino
	 */
	public void loadY() {
		// Y codons
		Y.add("TAT");
		Y.add("TAC");
	}

	/**
	 * Loads codons for W amino
	 */
	public void loadW() {
		// W codons
		W.add("TGG");
	}

	/**
	 * Loads codons for stop codes
	 */
	public void loadStop() {
		Stop.add("TAA");
		Stop.add("TAG");
		Stop.add("TGA");
	}

	/*
	 * OTHER METHODS
	 */

	/**
	 * Randomly selects a valid codon (3-letter base sequence) for a given amino
	 * acid letter code
	 * 
	 * @param amino
	 *            single-letter amino acid code
	 * @return codon for amino acid
	 */
	public String getValidCodon(String amino) {
		Random r = new Random();
		ArrayList<String> validCodons = get(amino);

		return validCodons.get(r.nextInt(validCodons.size()));

	}

	/**
	 * Gets all codons for an amino
	 * 
	 * @param amino
	 *            single-letter amino acid code
	 * @return all codon for amino acid
	 */
	public String getAllCodons(String amino) {
		ArrayList<String> validCodons = get(amino);
		String codons = "";

		for (int i = 0; i < validCodons.size(); i++) {
			codons += " " + validCodons.get(i);
		}

		return codons;

	}

	/**
	 * Gets base sequence corresponding to string of amino acids
	 * 
	 * @param aminoString
	 *            string of single-letter amino acids
	 * @precondition aminoString contains only valid single-letter amino acid
	 *               codes
	 */
	public String translateAminoString(String aminoString) {
		String baseSequence = "";

		for (int i = 0; i < aminoString.length(); i++) {
			baseSequence += getValidCodon((aminoString.substring(i, i + 1)));
		}

		return baseSequence;
	}

	/**
	 * Generates formatted output of dictionary contents
	 * 
	 * @return String formatted list of amino/Codon pairs
	 */
	@Override
	public String toString() {
		String aminoCodons = "";
		loadA();
		loadC();
		loadD();
		loadE();
		loadF();
		loadG();
		loadH();
		loadI();
		loadK();
		loadL();
		loadM();
		loadN();
		loadQ();
		loadR();
		loadS();
		loadT();
		loadV();
		loadY();
		loadW();
		loadStop();

		aminoCodons += "Amino \tCodons";
		aminoCodons += "\nA \t " + getAllCodons("A");
		aminoCodons += "\nC \t " + getAllCodons("C");
		aminoCodons += "\nD \t " + getAllCodons("D");
		aminoCodons += "\nE \t " + getAllCodons("E");
		aminoCodons += "\nF \t " + getAllCodons("F");
		aminoCodons += "\nG \t " + getAllCodons("G");
		aminoCodons += "\nH \t " + getAllCodons("H");
		aminoCodons += "\nI \t " + getAllCodons("I");
		aminoCodons += "\nK \t " + getAllCodons("K");
		aminoCodons += "\nL \t " + getAllCodons("L");
		aminoCodons += "\nM \t " + getAllCodons("M");
		aminoCodons += "\nN \t " + getAllCodons("N");
		aminoCodons += "\nP \t " + getAllCodons("P");
		aminoCodons += "\nQ \t " + getAllCodons("Q");
		aminoCodons += "\nR \t " + getAllCodons("R");
		aminoCodons += "\nS \t " + getAllCodons("S");
		aminoCodons += "\nT \t " + getAllCodons("T");
		aminoCodons += "\nV \t " + getAllCodons("V");
		aminoCodons += "\nY \t " + getAllCodons("Y");
		aminoCodons += "\nW \t " + getAllCodons("W");
		aminoCodons += "\nStop \t " + getAllCodons("*");

		return aminoCodons;
	}

}
