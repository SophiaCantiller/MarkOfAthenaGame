/**
 * Collection of iterable classes
 * Mostly collection of alike data types like array of objects
 * @author Sophia Feona Cantiller.
 */
package com.athena.iterables;

/**
 * 
 * 
 * Trivia class with question and answer
 * @author Sophia Feona Cantiller.
 *
 */
public class Trivia {
	/**
	 * Triviaa question
	 */
	private String question;
	
	/**
	 * Trivia answer
	 */
	private String answer;
	
	/**
	 * Constructor
	 * @param question Take a string for  Trivia question
	 * @param answer Take a string for answer
	 */
	public Trivia(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	/**
	 * Method that sets the question for the trivia
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
	 * Method that sets the answer for the trivia
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
		return this.answer.equals(answer);
	}
	
}
