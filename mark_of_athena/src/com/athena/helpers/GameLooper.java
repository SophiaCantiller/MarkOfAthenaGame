/**
 * Collection of helper classes which makes implementation of commands easier in the game
 * @author Sophia Feona Cantiller.
 */
package com.athena.helpers;

/**
 * 
 * 
 * GameLooper class that does the job in repeating the game if the player wants to
 * @author Sophia Feona Cantiller.
 *
 */
public class GameLooper {
	/**
	 * Answer of the player to repeat the game
	 */
	private char playAgain;
	
	/**
	 * Constructor
	 * Initially set to 'y' to loop the game
	 */
	public GameLooper() {
		this.playAgain = 'y';
	}
	
	/**
	 * Method that sets the playAgain answer of the player
	 * @param playAgain Takes a char for the answer of the player
	 */
	public void setPlayAgain(char playAgain) {
		this.playAgain = playAgain;
	}
	
	/**
	 * 
	 * @return Returns char the answer of the player
	 */
	public char getPlayAgain() {
		return this.playAgain;
	}
	
	/**
	 * 
	 * @return Returns boolean in looping the game
	 */
	public boolean loop() {
		if(this.getPlayAgain() == 'y' || this.getPlayAgain() == 'Y') {
			return true;
		}
		return false;
	}
}
