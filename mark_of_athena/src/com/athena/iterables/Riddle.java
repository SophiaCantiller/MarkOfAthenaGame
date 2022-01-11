/**
 * Collection of iterable classes
 * Mostly collection of alike data types like array of objects
 * @author Sophia Feona Cantiller.
 */
package com.athena.iterables;

import java.util.Random;

/**
 * 
 * 
 * Riddle class which has 3 choices and an answer
 * @author Sophia Feona Cantiller.
 *
 */
public class Riddle {
	
	/**
	 * Riddle question
	 */
	private String question;
	
	/**
	 * Choice 1
	 */
	private String choice1;
	
	/**
	 * Choice 2
	 */
	private String choice2;
	
	/**
	 * Choice 3
	 */
	private String choice3;
	
	/**
	 * Answer
	 */
	private String answer;
	
	/**
	 * Constructor
	 * @param question Take a string for  Riddle question
	 * @param choice1 Take a string for choice1
	 * @param choice2 Take a string for choice2
	 * @param choice3 Take a string for choice3
	 * @param answer Take a string for answer
	 */
	public Riddle(String question, String choice1, String choice2, String choice3, String answer) {
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.answer = answer;
	}
	
	/**
	 * Method that sets the question for the riddle
	 * @param question Takes a string for the question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * 
	 * @return Returns string for the  question
	 */
	public String getQuestion() {
		return this.question;
	}
	
	/**
	 * Method that sets the choice1 for the riddle
	 * @param choice1 Takes a string for the choice
	 */
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	
	/**
	 * 
	 * @return Returns string the choice1
	 */
	public String getChoice1() {
		return this.choice1;
	}
	
	/**
	 * Method that sets the choice2 for the riddle
	 * @param choice2 Takes a string for the choice
	 */
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	
	/**
	 * 
	 * @return Returns string the choice2
	 */
	public String getChoice2() {
		return this.choice2;
	}
	
	/**
	 * Method that sets the choice3 for the riddle
	 * @param choice3 Takes a string for the choice
	 */
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	
	/**
	 * 
	 * @return Returns string the choice3
	 */
	public String getChoice3() {
		return this.choice3;
	}
	
	/**
	 * Method that sets the answer for the riddle
	 * @param answer Takes a string for the answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	/**
	 * 
	 * @return Returns string the answer
	 */
	public String getAnswer() {
		return this.answer;
	}
	
	/**
	 * Method that checks if player answer and riddle answer are the same
	 * @param answer Takes string the answer of the player
	 * @return Returns boolean base on comparison
	 */
	public boolean checkAnswer(String answer) {
		if(answer == this.answer) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return Returns an array of string for the 3 choices
	 */
	public String[] getChoices() {
		Random random = new Random();
		String[] choices = {getChoice1(), getChoice2(), getChoice3()};
		for (int i = choices.length - 1; i > 0; i--)
		{
		  int index = random.nextInt(i + 1);
		  String temp = choices[index];
		  choices[index] = choices[i];
		  choices[i] = temp;
		}
		return choices;
	}

}
