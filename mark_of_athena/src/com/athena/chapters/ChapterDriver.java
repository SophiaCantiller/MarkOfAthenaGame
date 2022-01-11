/**
 * Collection of chapter classes that are playable in the course of the game.
 * @author Sophia Feona Cantiller.
 */
package com.athena.chapters;

/**
 * 
 * 
 * Chapter Drivers takes controls of all the chapters in the game.
 * It prevents the player to advance to another chapter without taking its prerequsuite
 * Only one chapter can be played at a time
 * @author Sophia Feona Cantiller.
 */
public class ChapterDriver implements iChapterDriver{
	
	/**
	 * Current chapter in game
	 */
	private int currentChapter;
	
	/**
	 * Constructor
	 * Initially set to 0 to initialize the start of the game
	 */
	public ChapterDriver() {
		this.currentChapter = 0;
	}
	
	@Override
	public void setInGame(int currentChapter) {
		this.currentChapter = currentChapter;
	}
	
	@Override
	public int getInGame() {
		return this.currentChapter;
	}

}
