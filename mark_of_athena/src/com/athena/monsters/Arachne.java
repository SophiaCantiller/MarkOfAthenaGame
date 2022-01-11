/**
 * Collection of monsters which can be encountered in the course of the game
 * @author Sophia Feona Cantiller.
 */
package com.athena.monsters;

import com.athena.bases.Monster;
import com.athena.player.Player;

/**
 * 
 * 
 * Monster Arachne
 * @author Sophia Feona Cantiller.
 *
 */
public class Arachne extends Monster {
	/**
	 * Voice lines of Arachne
	 */
	public String[] voiceLines;
	
	/**
	 * Constructor
	 * Initializes Arache
	 */
	public Arachne() {
		setName("Arachne");
		setInfo("This is Arachne");
		voiceLines = new String[3];
		voiceLines[0] = "Your mother didn't accept defeat. I wonder if losing would bode well for you.";
		voiceLines[1] = "I was always the better one. You are doomed to fail, just like your mother.";
		voiceLines[2] = "You will never get your hands on the statue, demigod of Athena.";
	}
	
	
	/**
	 * Inflicts damage to the player
	 * @param player Takes a player object
	 */
	public void inflictDamage(Player player) {
		player.setHealth(player.getHealth() - 2);
	}
	
	/**
	 * 
	 * @return Returns a random voiceline from Arachne
	 */
	public String getVoiceline() {
		return voiceLines[(int)Math.floor(Math.random()*(2-0+1)+0)];
	}
}
