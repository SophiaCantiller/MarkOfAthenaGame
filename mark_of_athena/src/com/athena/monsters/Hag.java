/**
 * Collection of monsters which can be encountered in the course of the game
 * @author Sophia Feona Cantiller.
 */
package com.athena.monsters;

import com.athena.bases.Monster;
import com.athena.player.*;

/**
 * 
 * 
 * Monster Hag
 * @author Sophia Feona Cantiller.
 *
 */
public class Hag extends Monster {
	/**
	 * Constructor
	 * Initializes Hag
	 */
	public Hag() {
		setName("Hag");
		setInfo("This is Hag");
	}
	
	/**
	 * Inflicts damage to the player
	 * @param player Takes a player object
	 */
	public void inflictDamage(Player player) {
		player.setHealth(player.getHealth() - 1);
	}
}
