/**
 * Collection of iterable classes
 * Mostly collection of alike data types like array of objects
 * @author Sophia Feona Cantiller.
 */
package com.athena.iterables;

/**
 * 
 * 
 * Array of riddles from the riddle objects
 * @author Sophia Feona Cantiller.
 *
 */
public class RiddleCollection {
	/**
	 * Array of riddles
	 */
	private Riddle[] riddles;
	
	/**
	 * Constructor
	 * Initializes the riddles array
	 */
	public RiddleCollection() {
		this.riddles = new Riddle[20];
		
		riddles[0] = new Riddle(
				"Some try to hide, some try to cheat; but time will show, we always will meet. Try as you might to guess my name.",
				"Professor", "Death", "Clock", "Death");
		riddles[1] = new Riddle(
				"Never resting, never still; moving silently from hill to hill; it does not walk, run or trot; all is cool where it is not.",
				"Car", "Human", "Sun", "Sun");
		riddles[2] =  new Riddle(
				"What is large, yet never grows; has roots that cannot be seen; and is taller than trees?",
				"Giant", "Mountains", "Planet", "Mountains");
		riddles[3] = new Riddle(
				"What can bring back the dead; make you cry, make you laugh, make you young; is born in an instant, yet lasts a lifetime.",
				"Time", "Human", "Memory", "Memory");
		riddles[4] = new Riddle(
				"I create my lair with earthen string, and dispatch my prey with a biting sting.",
				"Spider", "Cockroach", "Fly", "Spider");
		riddles[5] = new Riddle(
				"What is always old and sometimes new; never sad, sometimes blue; never empty, but sometimes full; never pushes, always pulls?",
				"Planets", "Sun", "Moon", "Moon");
		riddles[6] = new Riddle(
				"At night they come without being fetched, and by day they are lost without being stolen.",
				"Diamond", "Stars", "Gold", "Stars");
		riddles[7] = new Riddle(
				"What can run, but never walks; has a mouth, but never talks; has a head, but never weeps; has a bed, but never sleeps?",
				"Sea", "Lake", "River", "River");
		riddles[8] = new Riddle(
				"In spring I am gay in stunning array; in summer, more clothing I wear; when colder it grows, I fling off my clothes; and in winter quite naked appear.",
				"Waterfalls", "Trees", "Mountains", "Trees");
		riddles[9] = new Riddle(
				"I hear with no ears and speak with no mouth. I do not have a body, but I am alive when the wind blows.",
				"Wind", "Echo", "Music", "Echo");
		riddles[10] = new Riddle(
				"I disappear in the dark and appear in the day. You cannot feel me if you touch me.",
				"Sun", "Wind", "Shadow", "Shadow");
		riddles[11] = new Riddle(
				"I can run but I cannot walk and thoughts follow me wherever I go.",
				"Nose", "Eyes", "Ears", "Nose");
		riddles[12] = new Riddle(
				"If you feed me with food, I will survive. But if you make me drink water I will perish.",
				"Chimney", "Fire", "Wood", "Fire");
		riddles[13] = new Riddle(
				"I seem clear but when you look through me, things get warped. I can be used both for better and for worse.",
				"Spectacles", "Spoon", "Glass", "Glass");
		riddles[14] = new Riddle(
				"I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I? ",
				"Suburbs", "Map", "Country", "Map");
		riddles[15] = new Riddle(
				"Walk on the living. They don稚 even mumble. Walk on the dead. They mutter and grumble.",
				"Leaves", "Humans", "Trees", "Leaves");
		riddles[16] = new Riddle(
				"I go around in circles, but always straight ahead. I never complain no matter where I am led.",
				"Chariot", "Sun", "Wheel", "Wheel");
		riddles[17] = new Riddle(
				"If you drop me, I知 sure to crack but smile at me, and I値l always smile back.",
				"Glass", "Puddle", "Mirror", "Mirror");
		riddles[18] = new Riddle(
				"I知 lighter than what I am made of, and more of me is hidden than is seen.",
				"Forest", "Iceberg", "Mountain", "Iceberg");
		riddles[19] = new Riddle(
				"I知 tall when I知 young, and I知 short when I知 old.",
				"Wood", "Chimney", "Candle", "Candle");
	}
	
	/**
	 * 
	 * @return Returns the riddles array
	 */
	public Riddle[] getRiddles() {
		return this.riddles;
	}
	
	
}
