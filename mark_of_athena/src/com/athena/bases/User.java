/**
 * Collection of base classes which is necessary in creating further objects in the game
 * @author Sophia Feona Cantiller.
 */
package com.athena.bases;

/**
 * 
 *
 * Represents a user in the game
 * There can only be one player in the game
 * @author Sophia Feona Cantiller.
 *
 */
public abstract class User {

	/**
	 * Name of the user
	 */
	private String name;
	
	/**
	 * Methnd in setting the name of the user
	 * @param name Takes a string for the user name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return Returns string the name of the user
	 */
	public String getName() {
		return this.name;
	}
}
