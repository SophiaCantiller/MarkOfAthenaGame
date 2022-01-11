/**
 * Collection of chapter classes that are playable in the course of the game.
 * @author Sophia Feona Cantiller.
 */
package com.athena.chapters;

import com.athena.bases.Level;
import com.athena.helpers.MainHelper;
import com.athena.iterables.*;
import com.athena.monsters.Arachne;
import com.athena.player.Items;
import com.athena.player.Player;

/**
 * 
 * 
 * Chapter 4 is the final playable chapter in the game
 * Takes in the base level class then uses the chapter commands
 * @author Sophia Feona Cantiller.
 */
public class Chapter4 extends Level implements iChapterCommands {
	
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
	private Arachne arachne;
	
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
	
	public Chapter4(iChapterDriver chapterDriver, MainHelper mHelper) {
		this.chapterDriver = chapterDriver;
		this.mHelper = mHelper;
		this.hasPlayed = false;
		this.failed = true;
		arachne = new Arachne();
		setMonster(arachne);
		setLevel(4);
		setLocation("You are now in a cavern-like room.");
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
		String answer;
		int answered = 0;
		boolean isHealing = false;
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
				mHelper.printLine();
				mHelper.printDialog("Once you lost sight of the Sphinx, you begin to take notice of the spiders crawling on both sides of the wall.");
				mHelper.pressEnter();
				mHelper.printDialog("You walk into a room with a floor that looks weaved with delicate ropes, but it manages to hold your weight.");
				mHelper.pressEnter();
				mHelper.printDialog("Slowly, you made your way to the center of the room.");
				mHelper.pressEnter();
				mHelper.printDialog("That's when the walls started to shake, and you began to take notice of a looming shadow on a hallway at far right of the room. You never noticed it before.");
				mHelper.pressEnter();
				mHelper.printDialog("A creature slowly emerged. It looked like a humanoid spider.");
				mHelper.pressEnter();
				mHelper.printDialog("When the creature finally got out of the shadows, you see a woman with a spider's abdomen and eight legs. The woman clearly used to be beautiful, if not for its monstrous eyes and body.");
				mHelper.pressEnter();
				mHelper.printDialog(player.getName() + ": " + arachne.getName() + ". A pleasure to meet you.");
				mHelper.pressEnter();
				mHelper.printDialog(arachne.getName() + ": I can't say the same, Demigod of Athena. Look what your mother made of me!");
				mHelper.pressEnter();
				mHelper.printDialog(player.getName() + ": I am here for the Athena Parthenos. Where is it?");
				mHelper.pressEnter();
				mHelper.printDialog(arachne.getName() + ": Bold of you to assume I am going to give off information so easily. I challenge you into a weaving battle, demigod of Athena!");
				mHelper.pressEnter();
				mHelper.printDialog("===Arachne has challenged ou. To win this round, answer five questions correctly and no more than three questions incorrectly about Greek Mythology to weave a tapestry that could defeat Arachne!===");
				mHelper.printDialog("NOTE: Capitalize the first letter of each answer");
				mHelper.printSeparator();
				TriviaCollection triviaCollection = new TriviaCollection();
				TriviaIterator triviaIterator = new TriviaIterator(triviaCollection.getTrivias());
				Trivia[] trivias = new Trivia[5];
				for(int i = 0; i < 5; i++) {
					trivias[i] = (Trivia) triviaIterator.randomDraw();
				}
				while(answered < 5) {
					if(!failed) {
						if(player.getHealth() < 5) {
							int heal;
							isHealing = true;
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
						mHelper.printLine();
						mHelper.printDialog("TRIVIA #" + (answered+1) +": " + trivias[answered].getQuestion());
						answer = mHelper.getStrInput("Answer: ");
						if(trivias[answered].checkAnswer(answer)) {
							answered++;;
						}
						else {
							arachne.inflictDamage(player);
							mHelper.printDialog(">Your health has been diminished by 2!<");
							mHelper.printDialog(player.getHealthStatus());
							if(player.getHealth() == 0) {
								failed = true;
							}
							mHelper.pressEnter();
							mHelper.printDialog(arachne.getName() + ": " + arachne.getVoiceline());
							mHelper.pressEnter();	
						}
					}
				}
				if(answered == 5) {
					mHelper.printSeparator();
					mHelper.printDialog(">>Chapter 4 complete.<<");
					mHelper.printDialog("You have defeated Arachne. The cavern shook and almost at an instant, the Athena Parthenos stood tall before you. Arachne was nowhere to be found.");
					mHelper.pressEnter();
					mHelper.printDialog("CONGRATULATIONS! YOU HAVE WON THE GAME!");
					mHelper.pressEnter();
					mHelper.printSeparator();
					this.chapterDriver.setInGame(5);
					hasPlayed = true;
				}
			}
		}
		else {
			mHelper.printDialog("UNABLE TO PLAY CHAPTER. CHAPTER " + this.chapterDriver.getInGame() + " IS CURRENTLY ON PLAY");
		}
	}

}
