/**
 * Collection of chapter classes that are playable in the course of the game.
 * @author Sophia Feona Cantiller.
 */
package com.athena.chapters;

import com.athena.bases.*;
import com.athena.helpers.MainHelper;
import com.athena.monsters.*;
import com.athena.player.*;

/**
 * 
 * Chapter 1 is the first playable chapter in the game
 * Takes in the base level class then uses the chapter commands
 * @author Sophia Feona Cantiller.
 * 
 */
public class Chapter1 extends Level implements iChapterCommands {
	
	/**
	 * Controller of the chapter 
	 */
	private iChapterDriver chapterDriver;
	
	/**
	 * The one playing the game 
	 */
	private Player player;
	
	/**
	 * Present monster in the game
	 */
	private Hag hag;
	
	/**
	 * Helper class of the chapter
	 */
	private MainHelper mHelper;
	
	/**
	 * Key Items that the player have found
	 */
	private Items keyItems;
	
	/**
	 * Checker if the chapter has been finished playing
	 */
	private boolean hasPlayed;
	
	/**
	 * Checker for the souther route of the chapter
	 */
	private boolean isSouthVisited;
	
	/**
	 * Checker for the eastern route of the chapter
	 */
	private boolean isEastVisited;
	
	/**
	 * Checker for the chapter if the player fails
	 */
	private boolean failed;
	
	
	/**
	 * Chapter1 constructor
	 * @param chapterDriver takes the mediator for the chapter
	 * @param mHelper takes the helper class for the chapter
	 */
	public Chapter1(iChapterDriver chapterDriver, MainHelper mHelper) {
		this.chapterDriver = chapterDriver;
		this.mHelper = mHelper;
		this.hasPlayed = false;
		this.isSouthVisited = false;
		this.isEastVisited = false;
		this.failed = true;
		hag = new Hag();
		setLevel(1);
		setLocation("You are now in Greece.");
		setMonster(hag);
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
		this.player.loadPlayerDetails();
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public void setKeyItems(Items keyItems) {
		this.keyItems = keyItems;
		
	}

	@Override
	public Items getKeyItems() {
		return this.keyItems;
	}
	

	@Override
	public void playChapter() {
		int choice;
		if(this.chapterDriver.getInGame() == this.getLevel()) {
			mHelper.printDialog("Welcome to Chapter " + this.getLevel());
			mHelper.printDialog(getLocation());
			mHelper.printLine();
			mHelper.printDialog(player.getHealthStatus());
			while(!hasPlayed) {
				if(failed) {
					this.player.loadPlayerDetails();
					failed = false;
				}
				printMenu();
				choice = mHelper.getIntInput("Choice: ");
				switch(choice) {
					case 1:
						this.goNorth(this.keyItems.getYankeesCap());
						break;
					case 2:
						this.goSouth(isSouthVisited);
						break;
					case 3:
						this.goEast(isEastVisited);
						break;
				}
			}
		}
		else {
			mHelper.printDialog("UNABLE TO PLAY CHAPTER. CHAPTER 123 " + this.chapterDriver.getInGame() + " IS CURRENTLY ON PLAY");
		}
	}
	
	/**
	 * Method that takes care of displaying the chapter 1 main menu
	 */
	public void printMenu() {
		this.mHelper.printDialog("\nWhat do you do?\n\n" + 
								"[1] Walk north\n[2] Walk south\n[3] Walk east");
	}
	
	/**
	 * Methods that takes care whenever the players goes north
	 * @param yankeesCap Boolean key item yankeesCap needed for the route
	 */
	public void goNorth(boolean yankeesCap) {
		if (yankeesCap) {
			mHelper.printLine();
			mHelper.printDialog("Now with the cap of invisibility, you were able to go pass the hag without her noticing you.\n" + 
								"She smelled your blood as you passed by but her face just scrunched up with confusion as she was not able to see anyone nearby.");
			mHelper.pressEnter();
			mHelper.printDialog(">>You have successfully passed through the hag guarding the forest!<<");
			mHelper.pressEnter();
			this.chapterDriver.setInGame(2);
			mHelper.printSeparator();
			this.player.savePlayerDetails();
			hasPlayed = true;
		}
		else {
			int subChoice;
			boolean subLoop = true;
			mHelper.printLine();
			mHelper.printDialog("You walked north and encounter an old hag.");
			mHelper.pressEnter();
			mHelper.printDialog("Hag: I can smell the demigod in you. You are prohibited from entering this path.");
			mHelper.pressEnter();
			mHelper.printDialog("You peeked behind her and see a small pathway between the forest. You see a glint of red. What do you do?");
			while(subLoop) {
				if(!failed) {
					subChoice = mHelper.getIntInput("[1] Attack\n[2] Leave\nChoice: ");
					if(subChoice == 1) {
					mHelper.printLine();
					mHelper.printDialog("Hag: How dare you! ");
					mHelper.printDialog("The hag throws a curse at you.");
					mHelper.pressEnter();
					hag.inflictDamage(player);
					if(player.getHealth() == 0) {
						failed = true;
					}
					mHelper.printDialog(">Your health has been diminished by 1!<");
					mHelper.printDialog(player.getHealthStatus());
					mHelper.pressEnter();
					mHelper.printDialog("Hag: Careful, demigod! Fair warning!");
					mHelper.pressEnter();
					}
					else if(subChoice == 2) {
						subLoop = false;
					}
				}
				if(failed) {
					mHelper.printLine();
					mHelper.printDialog("You've ran out of health");
					mHelper.pressEnter();
					mHelper.printDialog("Game Over.");
					mHelper.pressEnter();
					hasPlayed = true;
					this.chapterDriver.setInGame(5);
					break;
				}
			}
		}
	}
	
	/**
	 * Methods that takes care whenever the players goes south
	 * @param isVisited boolean checking if the route has been visited already
	 */
	public void goSouth(boolean isVisited) {
		if(!isVisited) {
			mHelper.printLine();
			mHelper.printDialog("You walked south and found a treasure chest hidden behind a bush.");
			mHelper.pressEnter();
			mHelper.printDialog("The chest contained an old Yankees cap. You tried it on, and you noticed that you can't see your own hands at all.");
			mHelper.printDialog(player.getName() + ": This cap must be making me invisible.");
			keyItems.setYankeesCap(true);
			mHelper.printDialog("You examine the chest, and right at the unlocked key slot you see an embossed symbol of an owl. It's glowing red.");
			mHelper.pressEnter();
			isSouthVisited = true;
		}
		else {
			mHelper.printLine();
			mHelper.printDialog("There is nothing else here.");
			mHelper.pressEnter();
		}
		
		
	}
	
	/**
	 * Methods that takes care whenever the players goes east
	 * @param isVisited boolean checking if the route has been visited already
	 */
	public void goEast(boolean isVisited) {
		if(!isVisited) {
			mHelper.printLine();
			mHelper.printDialog("You walked east and found a velvet blue backpack. You opened it, and saw that it contained a stock of ambrosia and nectar inside.");
			keyItems.setAmbrosia(true);
			mHelper.pressEnter();
			mHelper.printDialog(player.restoreHealth(keyItems));
			isEastVisited = true;
		}
		else {
			mHelper.printLine();
			mHelper.printDialog("There is nothing else here.");
			mHelper.pressEnter();
		}
	}
	
	
	
	
}
