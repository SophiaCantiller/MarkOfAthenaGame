/**
 * Collection of base classes which is necessary in creating further objects in the game
 * @author Sophia Feona Cantiller.
 */
package com.athena.bases;

/**
 * 
 * 
 * Represents a level in the game.
 * Certain levels can be created and played in the game.
 * @author Sophia Feona Cantiller.
 *
 */
public abstract class Level {
	
	/**
	 * Level number of the game.
	 */
	private int level;
	
	/**
	 * Location of the level in game.
	 */
	private String location;
	
	/**
	 * Monster or enemy present in the game.
	 */
	private Monster monster;
	
	/**
	 * Method in setting the level of the game.
	 * @param level Takes an integer for the level.
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * 
	 * @return int Returns the current level of the game.
	 */
	public int getLevel() {
		return this.level;
	}
	
	/**
	 * Method in setting the location of the level in game.
	 * @param location Takes a string for the location.
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * 
	 * @return Returns string the current location of the game.
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Method in setting the monster of the level.
	 * @param monster Takes a monster object for the monster in the level.
	 */
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
	/**
	 * 
	 * @return Monster Returns the monster in the level.
	 */
	public Monster getMonster() {
		return this.monster;
	}
}
