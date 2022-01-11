/**
 * Collection of classes related to the player
 * Includes the items of the player
 * @author Sophia Feona Cantiller.
 */
package com.athena.player;

/**
 * 
 * 
 * Items that can be found the course of the game
 * @author Sophia Feona Cantiller.
 *
 */
public class Items {
	/**
	 * Dagger - fo Medusa
	 */
	private boolean dagger;
	
	/**
	 * Ambrosia - healing item
	 */
	private boolean ambrosia;
	
	/**
	 * Yankees Cap - provides invisibility needed for Hag
	 */
	private boolean yankeesCap;
	
	/**
	 * Ancient Key - unlocks the cabin of Medusa
	 */
	private boolean ancientKey;
	
	/**
	 * Constructor
	 * Sets all items to not found or false
	 */
	public Items() {
		this.dagger =  false;
		this.ambrosia = false;
		this.yankeesCap = false;
		this.ancientKey = false;
	}
	
	/**
	 * Sets the dagger
	 * @param found Take boolean if found
	 */
	public void setDagger(boolean found) {
		this.dagger =  found;
	}
	
	/**
	 * 
	 * @return Returns boolean dagger
	 */
	public boolean getDagger() {
		return this.dagger;
	}
	
	/**
	 * Sets the ambrosia
	 * @param found Take boolean if found
	 */
	public void setAmbrosia(boolean found) {
		this.ambrosia = found;
	}
	
	/**
	 * 
	 * @return Returns boolean ambrosia
	 */
	public boolean getAmbrosia() {
		return this.ambrosia;
	}
	
	/**
	 * Sets the yankeesCap
	 * @param found Take boolean if found
	 */
	public void setYankeesCap(boolean found) {
		this.yankeesCap =  found;
	}
	
	/**
	 * 
	 * @return Returns boolean yankeesCap
	 */
	public boolean getYankeesCap() {
		return this.yankeesCap;
	}
	
	/**
	 * Sets the ancientKey
	 * @param found Take boolean if found
	 */
	public void setAncientKey(boolean found) {
		this.ancientKey = found;
	}
	
	/**
	 * 
	 * @return Returns boolean ancientKey
	 */
	public boolean getAncientKey() {
		return this.ancientKey;
	}
}
