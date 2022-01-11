/**
 * Collection of chapter classes that are playable in the course of the game.
 * @author Sophia Feona Cantiller.
 */
package com.athena.chapters;

import com.athena.bases.*;
import com.athena.helpers.MainHelper;
import com.athena.monsters.*;
import com.athena.player.*;
import com.athena.iterables.*;

/**
 * 
 * 
 * Chapter 3 is the third playable chapter in the game
 * Takes in the base level class then uses the chapter commands
 * @author Sophia Feona Cantiller.
 */
public class Chapter3 extends Level implements iChapterCommands {
	
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
	private Sphinx sphinx;
	
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
	 * Chapter3 constructor
	 * @param chapterDriver takes the mediator for the chapter
	 * @param mHelper takes the helper class for the chapter
	 */
	public Chapter3(iChapterDriver chapterDriver, MainHelper mHelper) {
		this.chapterDriver = chapterDriver;
		this.mHelper = mHelper;
		this.hasPlayed = false;
		this.failed = true;
		sphinx = new Sphinx();
		setMonster(sphinx);
		setLevel(3);
		setLocation("You are now at the back door of Medusa's cabin.");
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
		int answer;
		int answered = 0;
		boolean isHealing = true;
		if(this.chapterDriver.getInGame() == this.getLevel()) {
			while(!hasPlayed) {
				if(failed) {
					this.player.loadPlayerDetails();
					failed = false;
				}
				mHelper.printDialog("Welcome to Chapter " + this.getLevel());
				mHelper.printDialog(getLocation());
				mHelper.printLine();
				mHelper.printDialog(player.getHealthStatus());
				mHelper.pressEnter();
				if(keyItems.getAmbrosia()) {
					while(isHealing) {
					if(!player.isHealthFull()) {
							choice = mHelper.getIntInput("Do you want to restore your health with ambrosia?\n\n[1] Yes\n[2] No\nChoice: ");
							if(choice == 1) {
								mHelper.printDialog(player.restoreHealth(keyItems));
								mHelper.printLine();
							} else {
								isHealing = false;
							}
						}
					else {
						isHealing = false;
						}
					}
				}
				mHelper.printLine();
				mHelper.printDialog("There is a door infront");
				mHelper.pressEnter();
				mHelper.printDialog("As the door opens, you find yourself in a rocky tavern. The wall is filled with spiders...");
				mHelper.pressEnter();
				mHelper.printDialog("You shiver at the sight of them, but you also took notice of the glowing red owl on the door right at the far end of the tavern.");
				mHelper.pressEnter();
				mHelper.printDialog("Ignoring the spiders, you start making your way through the door.");
				mHelper.pressEnter();
				mHelper.printDialog("The glowing red owl is actually a door knocker. ");
				mHelper.printDialog("Without thinking twice, you take hold of the glowing owl and used it to tap the door.");
				mHelper.pressEnter();
				mHelper.printDialog("The door opened swiftly and inside was a monstrous yet regal creature, with a body of a lion and head of a human. It had a set of falcon-like wings.");
				mHelper.pressEnter();
				mHelper.printDialog("It's the Sphinx.");
				mHelper.pressEnter();
				mHelper.printDialog("Sphinx: Demigod of Athena. I know what you're here for. You stand no chance.");
				mHelper.pressEnter();
				mHelper.printDialog(player.getName() + ": I know I stand a chance if I were to answer your riddles.");
				mHelper.pressEnter();
				mHelper.printDialog("Sphinx: I doubt you can answer them.");
				mHelper.pressEnter();
				mHelper.printDialog(player.getName() + "I am a Demigod of Athena.");
				mHelper.pressEnter();
				mHelper.printDialog("The Sphinx sneered and looked at you with disgust.");
				mHelper.pressEnter();
				mHelper.printDialog("Sphinx: Fine. Answer two of my three my riddles correctly and I will let you pass. Fail, and I will kill you!");
				mHelper.pressEnter();
				mHelper.printSeparator();
				mHelper.printDialog("ANSWER AT LEAST THREE OF THE SPHINX'S RIDDLES CORRECTLY TO PASS THE LEVEL!");
				mHelper.pressEnter();
				mHelper.printDialog(player.getHealthStatus());
				RiddleCollection riddleCollection = new RiddleCollection();
				RiddleIterator riddleIterator = new RiddleIterator(riddleCollection.getRiddles());
				Riddle[] riddles = new Riddle[3];
				for(int i = 0; i < 3; i++) {
					riddles[i] = (Riddle) riddleIterator.randomDraw();
				}
				while(answered < 3) {
					if(!failed) {
						if(player.getHealth() < 5) {
							int heal;
							isHealing = true;
							mHelper.printDialog(player.getHealthStatus());
							mHelper.printDialog("You are low on health");
							while(isHealing) {
								mHelper.printLine();
								mHelper.printDialog("[1] Heal using ambrosia (" + player.getHealPoints() + " heal points remaining)\n[2] Continue");
								heal = mHelper.getIntInput("Choice: ");
								if(heal == 1) {
									mHelper.printDialog(player.restoreHealth(keyItems));
								} else {
									isHealing = false;
								}	
							}
						}
						int correctAnswer = 0;
						mHelper.printLine();
						mHelper.printDialog("RIDDLE #" + (answered+1) + ": " + riddles[answered].getQuestion());
						String[] choices = riddles[answered].getChoices();
						for(int i = 0; i < choices.length; i++) {
							mHelper.printDialog("[" + (i+1) + "] " + choices[i]);
							if(riddles[answered].checkAnswer(choices[i])) {
								correctAnswer = i+1;
							}
						}
						answer = mHelper.getIntInput("Answer: ");
						if(answer == correctAnswer) {
							answered++;
						}
						else {
							sphinx.inflictDamage(player);
							mHelper.printDialog(">Your health has been diminished by 2!<");
							mHelper.printDialog(player.getHealthStatus());
							if(player.getHealth() == 0) {
								failed = true;
							}
							mHelper.pressEnter();
							mHelper.printDialog("Sphinx: " + sphinx.getVoiceline());
							mHelper.pressEnter();	
						}
					}
					if(failed) {
						mHelper.printLine();
						mHelper.printDialog("You blacked out.");
						mHelper.pressEnter();
						mHelper.printDialog("You'll will be starting this chapter all over again");
						mHelper.pressEnter();
						answered = 0;
						break;
					}
				}
				if(answered == 3) {
					mHelper.printLine();
					mHelper.printDialog("Sphinx: Clever, Demigod of Athena. You may now pass.");
					mHelper.pressEnter();
					mHelper.printDialog(">>Chapter 3 complete.<<");
					mHelper.pressEnter();
					this.chapterDriver.setInGame(4);
					mHelper.printLine();
					mHelper.printSeparator();
					hasPlayed = true;
				}
				
			}
		} else {
			mHelper.printDialog("UNABLE TO PLAY CHAPTER. CHAPTER " + this.chapterDriver.getInGame() + " IS CURRENTLY ON PLAY");
		}
		
	}
}
