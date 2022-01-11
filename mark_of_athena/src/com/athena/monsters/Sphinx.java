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
 * Monster Sphinx
 * @author Sophia Feona Cantiller.
 *
 */
public class Sphinx extends Monster {
	/**
	 * Voice lines of Sphinx
	 */
	public String[] voiceLines;
	
	/**
	 * Constructor
	 * Initializes Sphinx
	 */
	public Sphinx() {
		setName("Sphinx");
		setInfo("This is Sphinx");
		voiceLines = new String[3];
		voiceLines[0] = "You're running out if time, demigod of Athena.";
		voiceLines[1] = "Seems like you're not as witty as you thought you are.";
		voiceLines[2] = "Trying to get by with an incorrect answer? You're so much better than that.";
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
	 * @return Returns a random voiceline from Sphinx
	 */
	public String getVoiceline() {
		return voiceLines[(int)Math.floor(Math.random()*(2-0+1)+0)];
	}
}
