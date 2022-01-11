/**
 * Package for the main class of the game
 * Main method here
 * @author Sophia Feona Cantiller.
 */
package com.athena.main;

import com.athena.chapters.*;
import com.athena.helpers.MainHelper;
import com.athena.helpers.GameLooper;
import com.athena.helpers.GameStarter;

/**
 * Main class of the Mark of Athena console game
 * @author Sophia Feona Cantiller
 *
 */
public class Athena {
	public static void main(String[]args) {
		// Main Helper class
		MainHelper mHelper = new MainHelper();
		
		// Game Looper class
		GameLooper looper = new GameLooper();
		
		// Game Starter class
		GameStarter starter = new GameStarter();
		
		// Chapters
		Chapter1 chapter1 = null;
		Chapter2 chapter2 = null;
		Chapter3 chapter3 = null;
		Chapter4 chapter4 = null;
		
		// Chapter Mediator
		iChapterDriver chapterMediator = new ChapterDriver();
		
		// Starts the lopp
		while(looper.loop() ) {
			// Plays the chapter base on the value of its mediator
			switch(chapterMediator.getInGame()) {
				// 0 will start the game
				case 0:
					starter.startGame();
					chapterMediator.setInGame(1);
					break;
				case 1:
					chapter1 = new Chapter1(chapterMediator, mHelper);
					chapter1.setPlayer(starter.getPlayer());
					chapter1.setKeyItems(starter.getKeyItems());
					chapter1.playChapter();
					break;
				case 2:
					chapter2 = new Chapter2(chapterMediator, mHelper);
					chapter2.setPlayer(chapter1.getPlayer());
					chapter2.setKeyItems(chapter1.getKeyItems());
					chapter2.playChapter();
					break;
				case 3:
					chapter3 = new Chapter3(chapterMediator, mHelper);
					chapter3.setPlayer(chapter2.getPlayer());
					chapter3.setKeyItems(chapter2.getKeyItems());
					chapter3.playChapter();
				case 4:
					chapter4 = new Chapter4(chapterMediator, mHelper);
					chapter4.setPlayer(chapter3.getPlayer());
					chapter4.setKeyItems(chapter3.getKeyItems());
					chapter4.playChapter();
					break;
				// Prompts the player if play again
				default: 
					looper.setPlayAgain(mHelper.getCharInput("Do you want to play again? (y/n): "));
					mHelper.printLine();
					starter.startGame();
					chapterMediator.setInGame(1);
					mHelper.printDialog("That ends the adventure of " + chapter1.getPlayer().getName() + ".");
					mHelper.pressEnter();
					mHelper.printDialog("Thank you for playing \"The Mark of Athena: A Quest For The Athena Parthenos\".");
					break;
			}
		}
	}
}
