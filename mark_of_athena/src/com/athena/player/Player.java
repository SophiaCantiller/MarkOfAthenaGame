/**
 * Collection of classes related to the player
 * Includes the items of the player
 * @author Sophia Feona Cantiller.
 */
package com.athena.player;

import com.athena.bases.User;

/**
 * 
 * 
 * The player class which is a vital character in the game
 * Only one player at a time
 * Takes in the base user class
 * @author Sophia Feona Cantiller.
 * 
 */
public class Player extends User{
	
	/**
	 * Player healtth 
	 */
	private int health;
	
	/**
	 * Player healPoints
	 */
	private int healPoints;
	
	/**
	 * Player saved health after a chapter
	 */
	private int savedHealth;
	
	/**
	 * Player remaining heal points after a chapter
	 */
	private int savedHealPoints;
	
	
	/**
	 * Constructor
	 * Initializes the player
	 * @param name Takes a string for the player name
	 * @param health Takes an int for the player health
	 */
	public Player(String name, int health) {
		setName(name);
		this.health =  health;
		healPoints = 10;
	}
	
	/**
	 * Saves the player details after each chapter
	 */
	public void savePlayerDetails() {
		this.savedHealth = this.health;
		this.savedHealPoints = this.healPoints;
	}
	
	/**
	 * Loadss the saved details to the current player
	 */
	public void loadPlayerDetails() {
		this.health = this.savedHealth;
		this.healPoints = this.savedHealPoints;
	}
	
	/**
	 * Sets player health
	 * @param health Takes a string for the health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * 
	 * @return Returns string the player health
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * 
	 * @return Returns string the player status
	 */
	public String getHealthStatus() {
		return  "Health: " + this.health;
	}
	
	/**
	 * sets the player heal points
	 * @param healPoints Takes a string for the heal points
	 */
	public void setHealPoints(int healPoints) {
		this.healPoints = healPoints;
	}
	
	/**
	 * 
	 * @return Retuns int for the player heal points
	 */
	public int getHealPoints() {
		return this.healPoints;
	}
	
	/**
	 * Restores player health
	 * @param keyItems Gets item. Needs the ambrosia
	 * @return Return string the heal message
	 */
	public String restoreHealth(Items keyItems) {
		if(keyItems.getAmbrosia()) {
			if(this.healPoints > 0) {
				if(this.health < 10) {
					this.health++;
					this.healPoints--;
					return ">>Your health is now restored by 1 point!<<\n" + 
							this.getHealthStatus();
				}
				else {
					return ">>You're still in full health.<<";
				}
			} else {
				return ">>No more remaining heal points<<";
			}
		} else {
			return ">>Unable to heal. Ambrosia is missing.<<";
		}
		
	}
	
	/**
	 * Checks player health is full
	 * @return Returns boolean base on comparison
	 */
	public boolean isHealthFull() {
		if(this.health == 10) {
			return true;
		} else {
			return false;
		}
	}

}
