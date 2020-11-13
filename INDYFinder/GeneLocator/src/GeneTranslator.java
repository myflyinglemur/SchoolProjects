import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


/**
 * Translates a string of amino acids to a string of nucelotide bases
 * 
 * @author rachellowy
 * @version 12 Dec 2016
 */
public class GeneTranslator {
	public static void main(String[] args) throws FileNotFoundException {
		AminoDictionary aminoDict = new AminoDictionary();
		
		System.out.println(aminoDict);
		
		System.out.println("Tranlated gene saved in: .../Genomes/geneINDY/translated INDY.txt");
	}
}
