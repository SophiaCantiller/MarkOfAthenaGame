/**
 * Collection of chapter classes that are playable in the course of the game.
 * @author Sophia Feona Cantiller.
 */
package com.athena.chapters;

/**
 * 
 * 
 * Chapter interface class for the driver of the chapters
 * @author Sophia Feona Cantiller.
 */
public interface iChapterDriver {
	/**
	 * Sets the chapter in game
	 * @param currentChapter int takes the current chapter
	 */
	public void setInGame(int currentChapter);
	
	/**
	 * 
	 * @return Returns int the current chapter in game
	 */
	public int getInGame();
}
