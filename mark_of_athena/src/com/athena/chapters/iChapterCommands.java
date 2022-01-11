/**
 * Collection of chapter classes that are playable in the course of the game.
 * @author Sophia Feona Cantiller.
 */
package com.athena.chapters;

import com.athena.player.*;

/**
 * 
 * @author Sophia Feona Cantiller.
 * Chapter command interface class for every chapter
 */
public interface iChapterCommands {
	
	/**
	 * Method that sets the player playing the chapter
	 * @param player Takes a player object for the chapter
	 */
	public void setPlayer(Player player);
	
	/**
	 * 
	 * @return Returns player who finished playing the chapter
	 */
	public Player getPlayer();
	
	/**
	 * Methods that sets the keyItems found by the player from the previous chapter
	 * @param keyItems Takes an Item object for the chapter
	 */
	public void setKeyItems(Items keyItems);
	
	/**
	 * 
	 * @return Returns the keyItems of the player
	 */
	public Items getKeyItems();
	
	/**
	 * Runs the chapter to be played by the player
	 */
	public void playChapter();
}
