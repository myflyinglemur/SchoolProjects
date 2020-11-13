import java.util.ArrayList;

/**
 * This program holds DNA for a single species that are obtained from several different locations.  
 * It was created for CSC 143.
 * 
 * @author rachellowy
 * @version 7 Dec 2016
 *
 */
public class Genome {
	String species;
	ArrayList<DNA> genome = new ArrayList<DNA>();
	
	/** 
	 * Constructs a genome to hold DNA
	 * 
	 * @param species name a species for this genome
	 */
	public Genome(String species) {
		this.species = species;
	}

	/**
	 * Adds a DNA sequence to the genome
	 * 
	 * @param dna DNA object holding FASTA letter sequence
	 */
	public void add(DNA dna) {
		genome.add(dna);
	}
	
	/**
	 * Gets the name of the species NDA
	 * 
	 * @return name of the species
	 */
	public String getSpecies() {
		return this.species;
	}
	
	/**
	 * Gets the number of DNA sequences in the genome 
	 * 
	 * @return number of DNA sequences in genome
	 */
	public int getSize() {
		return genome.size();
	}

	/**
	 * Gets the DNA sequence stored at a genome index
	 * 
	 * @param index index where desired DNA resides
	 * @return DNA sequence at the index
	 */
	public DNA get(int index) {
		return genome.get(index);
	}
	
	/**
	 * Gets a well-formatted output of all DNA in the genome, separated
	 * by the file index
	 * 
	 * @return ordered DNA sequence of genome
	 * 
	 */
	@Override
	public String toString() {
		String output = "Drosophilia " + species + " Genome: \n";

		int index = 0;
		while (index < genome.size()) {
			output += "\nindex: " + index;
			output += "\n" + genome.get(index);
			output += "\n";
			index += 1;
		}
		
		return output;
	}

}
