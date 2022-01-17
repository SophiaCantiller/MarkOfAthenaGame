/**
 * Collection of iterable classes
 * Mostly collection of alike data types like array of objects
 * @author Sophia Feona Cantiller.
 */
package com.athena.iterables;

/**
 * 
 * 
 * Array of trivias from the trivias objects
 * @author Sophia Feona Cantiller.
 *
 */
public class TriviaCollection {
	/**
	 * Array of trivias
	 */
	private Trivia[] trivias;
	
	/**
	 * Constructor
	 * Initializes the trivias array
	 */
	public TriviaCollection() {
		this.trivias = new Trivia[20];
		
		trivias[0] = new Trivia("Who is the supreme god of Olympus?", "Zeus");
		trivias[1] = new Trivia("What fruit did Persephone eat to get her stuck in the Underworld?", "Pomegranate");
		trivias[2] = new Trivia("What is the Greek name for mercury?", "Hermes");
		trivias[3] = new Trivia("What god was in a competition for the love of the people of the area around the Acropolis with Athena?", "Poseidon");
		trivias[4] = new Trivia("Who is the goddess of victory?", "Nike");
		trivias[5] = new Trivia("Who slew the nine headed hydra?", "Hercules");
		trivias[6] = new Trivia("Who gave fire to the mortals?", "Prometheus");
		trivias[7] = new Trivia("Who is known for flying too close to the sun?", "Icarus");
		trivias[8] = new Trivia("Who is the god of music and light?", "Apollo");
		trivias[9] = new Trivia("Who was the Greek hero of the Trojan War?", "Achilles");
		trivias[10] = new Trivia("Her gaze could turn you to stone, who holds this power?", "Medusa");
		trivias[11] = new Trivia("Who was the first Olympian?", "Hestia");
		trivias[12] = new Trivia("What is the Greek name for Cupid?", "Eros");
		trivias[13] = new Trivia("Who is the god of sleep?", "Hypnos");
		trivias[14] = new Trivia("Who is the King of underworld and dead?", "Hades");
		trivias[15] = new Trivia("Which god is responsible for war and bloodshed?", "Ares");
		trivias[16] = new Trivia("What was Poseidon’s animal?", "Horse");
		trivias[17] = new Trivia("In Greek mythology, who was the goddess of the rainbow?", "Rainbow");
		trivias[18] = new Trivia("What was the Greek hero Achilles’ only vulnerable part?", "Heel");
		trivias[19] = new Trivia("What ancient Greek city is famous for its oracle?", "Delphi");
	}
	
	/**
	 * 
	 * @return Returns the trivias array
	 */
	public Trivia[] getTrivias() {
		return this.trivias;
	}
}
