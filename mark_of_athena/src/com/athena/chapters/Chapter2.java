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
 * 
 * Chapter 2 is the second playable chapter in the game
 * Takes in the base level class then uses the chapter commands
 * @author Sophia Feona Cantiller.
 */
public class Chapter2 extends Level implements iChapterCommands {
	
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
	private Medusa medusa;
	
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
	 * Checker for the chapter if the player fails
	 */
	private boolean failed;


	/**
	 * Checker for the detour route of the chapter
	 */
	private boolean isDetourVisited;
	
	/**
	 * Chapter2 constructor
	 * @param chapterDriver takes the mediator for the chapter
	 * @param mHelper takes the helper class for the chapter
	 */
	public Chapter2(iChapterDriver chapterDriver, MainHelper mHelper) {
		this.chapterDriver = chapterDriver;
		this.mHelper = mHelper;
		this.hasPlayed = false;
		this.isDetourVisited = false;
		this.failed = true;
		medusa = new Medusa();
		setLevel(1);
		setMonster(medusa);
		setLevel(2);
		setLocation("You are now inside the forest");
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
			while(!hasPlayed) {
				if(failed) {
					mHelper.printDialog("Welcome to Chapter " + this.getLevel());
					mHelper.printDialog(getLocation());
					mHelper.printLine();
					mHelper.printDialog(player.getHealthStatus());
					failed = false;
				}
				else {
					printMenu();
					choice = mHelper.getIntInput("Choice: ");
					
					switch(choice) {
						case 1:
							enterCabin(keyItems.getAncientKey());
							break;
						case 2:
							takeDetour(isDetourVisited);
							break;
					}
				}
			}
			
		}
		else {
			mHelper.printDialog("UNABLE TO PLAY CHAPTER. CHAPTER " + this.chapterDriver.getInGame() + " IS CURRENTLY ON PLAY");
		}
		
	}
	
	/**
	 * Method that takes care of displaying the chapter 2 main menu
	 */
	public void printMenu() {
		this.mHelper.printDialog("\nWhat do you do?\n\n" + 
				"[1] Go straight ahead\n[2] Go left");
	}
	
	/**
	 * Methods that takes care whenever the players enters the cabin
	 * @param ancientKey Boolean key item ancientKey needed for the route
	 */
	public void enterCabin(boolean ancientKey) {
		if(ancientKey) {
			int num = 0;
			int subChoice;
			boolean subLoop = true;
			boolean innerLoop = true;
			mHelper.printLine();
			mHelper.printDialog("You hold the key securely inside your hands. You wear the hat on for extra security, and approached the abandoned-looking cabin.");
			mHelper.pressEnter();
			mHelper.printDialog("The key perfectly fits the lock on the door. You twist it open.");
			mHelper.pressEnter();
			mHelper.printDialog("Hiss...\nHiss...\nHiss...");
			mHelper.pressEnter();
			mHelper.printDialog("Hiss...\nHiss...\nHiss...");
			mHelper.printLine();
			mHelper.printDialog("The hissing sound seems to be nearby...");
			mHelper.printDialog("As you took a step in the dark empty room, you bumped into something and you fell on the floor. The sound of snakes still lingers...");
			mHelper.printDialog("A woman's voice: Well, well. Sounds like a puny demigod just got their ssssself into ssssome big trouble...Sssshow yoursssself.");
			mHelper.pressEnter();
			mHelper.printDialog("The woman's voice sounded near to your left and you start to make out her silhouette.");
			mHelper.pressEnter();
			mHelper.printDialog("She had a slendes figure and from the looks of it, she is wearing a medieval dress with a color you still can't make out of the darkness, but there's one thing you're sure of...");
			mHelper.printDialog(player.getName() + ": It's Medusa!");
			mHelper.printDialog("Medusa: I heard you. I can ssssniff your tassssty demigod blood from here.");
			while(num!=1) {
				mHelper.printLine();
				num = mHelper.getIntInput("Enter 1 to move backwards: ");
			}
			mHelper.printDialog("You start to move backwards from the position you fell into, but as you pushed your hand to the back, ");
			mHelper.printDialog("you bumped into the shelves behind you and a couple books toppled over and hit your head, knocking out your cap.");
			mHelper.pressEnter();
			mHelper.printDialog("You start to panic but there's no way out now. ");
			mHelper.printDialog("Medusa: Got you.");
			mHelper.pressEnter();
			while(subLoop) {
				subChoice = mHelper.getIntInput("\nWhat do you do?\n\n[1] Close your eyes\n[2] Attack Medusa\nChoice: ");
				switch(subChoice) {
					case 1:
						mHelper.printLine();
						mHelper.printDialog("You close your eyes and sat still.");
						mHelper.pressEnter();
						mHelper.printDialog("The hissing grew nearer and you felt Medusa sliding towards you.");
						mHelper.printDialog("You shiver in fear.");
						mHelper.pressEnter();
						subChoice = mHelper.getIntInput("\nWhat do you do?\n\n[1] Slice Medusa's head with your dagger\n[2] Cower in fear\nChoice: ");
						while(innerLoop) {
							switch(subChoice) {
								case 1:
									if(keyItems.getDagger()) {
										mHelper.printLine();
										mHelper.printDialog("In a flash, coupled with the adrenaline coursing through your veins, you " +
															"grabbed your dagger in a swift motion and went straight to Medusa's neck,\n" +
															"estimating where her nape would be and went for the kill with your eyes closed.");
										mHelper.pressEnter();
										mHelper.printDialog("There was a loud thud and the sound of snakes became no more.");
										mHelper.pressEnter();
										mHelper.printDialog("You start to kick your way around to find where her head is, and with a spare blanket that you have on your backpack, you covered it.");
										mHelper.pressEnter();
										mHelper.printDialog(">>You defeated Medusa! Chapter 2 complete.<<");
										mHelper.pressEnter();
										this.player.savePlayerDetails();
										this.chapterDriver.setInGame(3);
										mHelper.printLine();
										mHelper.printSeparator();
										innerLoop = false;
										subLoop = false;
										hasPlayed = true;
									}
									else {
										mHelper.printLine();
										mHelper.printDialog("Dagger is missing.");
										mHelper.pressEnter();
									}
									break;
								case 2:
									mHelper.printLine();
									mHelper.printDialog("Struck with fear, you lower your head and hoped for the best.");
									mHelper.pressEnter();
									mHelper.printDialog("But you thought too soon—as you felt Medusa's hands crawling its way to your neck.");
									mHelper.pressEnter();
									mHelper.printDialog("You are already choking, and the pain becomes too unbearable that you are forced to open your eyes and look straight into Medusa's deathly gaze.");
									mHelper.pressEnter();
									mHelper.printDialog(">> You just have been turned into one of Medusa's statue decorations. <<");
									mHelper.printDialog(">> You have to redeem yourself. You will be redirected to the start of the chapter <<");
									mHelper.pressEnter();
									innerLoop = false;
									subLoop = false;
									failed = true;
									break;
									
							}
						}
						break;
					case 2:
						mHelper.printLine();
						mHelper.printDialog("Unplanned, you went straight for Medusa.");
						mHelper.pressEnter();
						mHelper.printDialog("Your eyes weren't closed and there was a split-second realization...");
						mHelper.pressEnter();
						mHelper.printDialog("...right before you turned into stone. ");
						mHelper.pressEnter();
						mHelper.printDialog(">>Congratulations for making it into Medusa's prized collections, but you failed the level.<<");
						mHelper.printDialog("You'll go back to the start of the chapter");
						mHelper.pressEnter();
						innerLoop = false;
						subLoop = false;
						failed = true;
						keyItems.setAncientKey(false);
						isDetourVisited = false;
						medusa.inflictDamage(player);
						break;
						
				}
			}
			
			
		}
		else {
			mHelper.printLine();
			mHelper.printDialog("You walked straight ahead and saw a cabin. You approached it but it's locked.");
			mHelper.pressEnter();
		}
	}
	
	/**
	 * Methods that takes care whenever the players takes the detour
	 * @param isVisited boolean checking if the route has been visited already
	 */
	public void takeDetour(boolean isVisited) {
		if(!isVisited) {
			mHelper.printLine();
			mHelper.printDialog("You took a detour and went left. There, you see a tree with bright red spot glowing at the bottom of its trunk.");
			mHelper.printDialog("It's the same one you saw on the treasure chest. The Mark of Athena.");
			mHelper.printDialog("You look a little closer and see that an ancient key has been strategically placed in between the curves of the trunk. You picked it up.");
			keyItems.setAncientKey(true);
			isDetourVisited = true;
			mHelper.pressEnter();
		} else {
			mHelper.printLine();
			mHelper.printDialog("There is nothing else here.");
			mHelper.pressEnter();
		}
	}
}