/**
 * Collection of base classes which is necessary in creating further objects in the game
 * @author Sophia Feona Cantiller.
 */
package com.athena.bases;

/**
 * 
 * 
 * Represents a monster in the game
 * One or more monsters can be encountered in the game
 * @author Sophia Feona Cantiller.
 *
 */
public abstract class Monster {
	
	/**
	 * Name of the monster
	 */
	private String name;
	/**
	 * Additional information for the monster
	 */
	private String info;
	
	/**
	 * Method in setting the name of the monster
	 * @param name Takes a string for the monster name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return Returns string the name of the monster
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method in setting the info of the monster
	 * @param info Takes a string for the monster info.
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
	/**
	 * 
	 * @return Returns string the info of the user
	 */
	public String getInfo() {
		return this.info;
	}

}
