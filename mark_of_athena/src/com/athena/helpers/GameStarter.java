/**
 * Collection of helper classes which makes implementation of commands easier in the game
 * @author Sophia Feona Cantiller.
 */
package com.athena.helpers;

import com.athena.player.*;

/**
 * 
 * 
 * GameStarter class that does the job in initially starting the game
 * @author Sophia Feona Cantiller.
 *
 */
public class GameStarter {
	/**
	 * Player for the game
	 */
	private Player player;
	
	/**
	 * Key Items of the player
	 */
	private Items keyItems;
	
	/**
	 * Helper of the class
	 */
	private MainHelper mHelper;
	
	/**
	 * Constructor
	 */
	public GameStarter() {
		this.mHelper = new MainHelper();
	}
	
	/**
	 * Initializes the player for the game
	 * @param playerName Takes a string for the player name
	 */
	public void setPlayer(String playerName) {
		this.player =  new Player(playerName, 10);
		this.keyItems = new Items();
	}
	
	/**
	 * 
	 * @return Returns the player to be taken later by the chapters
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * 
	 * @return Returns the key items of the player
	 */
	public Items getKeyItems() {
		return this.keyItems;
	}
	
	/**
	 * Game starter method
	 */
	public void startGame() {
		String playerName = null;
		
		mHelper.printDialog("========THE MARK OF ATHENA========");
		mHelper.printDialog("A Quest For The Athena Parthenos");
		mHelper.printDialog("==================================\n");
		mHelper.pressEnter();
		mHelper.printLine();
		
		mHelper.printDialog("Wisdom's daughter walks alone, the Mark of Athena burns through rome...");
		mHelper.printLine();
		mHelper.printSeparator();
		mHelper.printDialog("Follow the Mark of Athena...Avenge me...");
		mHelper.pressEnter();
		mHelper.printSeparator();
		playerName = mHelper.getStrInput("Please enter your name: ");
		this.setPlayer(playerName);
		this.player.savePlayerDetails();
		mHelper.printLine();
		mHelper.printSeparator();
		mHelper.printDialog("Welcome " + this.player.getName() + ", Demigod of Athena. \n" +
				"You have chosen to take on the challenge of finding the Athena Parthenos, \n" + 
				"the statue that could seal the riff between us Roman and Greek Demigods. \n" + 
				"You sister Annabeth Chase is currently in Tartarus and failed her quest, \n" +
				"so the responsibility now falls on you.");
		mHelper.pressEnter();
		mHelper.printDialog("You are tasked to complete this quest, or else Greece will be doomed. \n" +
				"And it will all be your fault if it does. ");
		mHelper.pressEnter();
		mHelper.printDialog("Take this dagger. Don't forget your ambrosia and nectar as well. \n" + 
				"You will need these to heal yourself. You are all alone now.");
		keyItems.setDagger(true);
		mHelper.printSeparator();
		mHelper.pressEnter();
	}
	
	
}
