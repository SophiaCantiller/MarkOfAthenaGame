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
 * Monster Medusa
 * @author Sophia Feona Cantiller.
 *
 */
public class Medusa extends Monster {
	public Medusa() {
		setName("Medusa");
		setInfo("This is Medusa");
	}
	
	/**
	 * Inflicts damage to the player
	 * @param player Takes a player object
	 */
	public void inflictDamage(Player player) {
		player.setHealth(player.getHealth() - 2);
	}
}
