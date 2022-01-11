/**
 * Collection of helper classes which makes implementation of commands easier in the game
 * @author Sophia Feona Cantiller.
 */
package com.athena.helpers;

import java.util.Scanner;

/**
 * 
 * 
 * MainHelper class that does the general helping around the game
 * @author Sophia Feona Cantiller.
 *
 */
public class MainHelper {
	/**
	 * Scanner for enters inputs
	 */
	
	/**
	 * Scanner for string/char inputs
	 */
	private Scanner scEnter = new Scanner(System.in);
	private Scanner scStr = new Scanner(System.in);
	
	/**
	 * Scanner for integer inputs
	 */
	private Scanner scInt = new Scanner(System.in);
	
	/**
	 * Method that commands the player to press the enter key
	 */
	public void pressEnter() {
		System.out.println("[Enter to Continue]");
		scEnter.nextLine();
	}
	
	/**
	 * Methods that prints out a new line as a separator for the dialogs
	 */
	public void printLine() {
		System.out.println();
	}
	
	/**
	 * Method that returns a string input
	 * @param msg Takes a string which guides the player what to input
	 * @return Returns string the player input
	 */
	public String getStrInput(String msg) {
		String str;
		System.out.print(msg);
		str = scStr.nextLine();
		return str;
	}
	
	/**
	 * Method that returns a char input
	 * @param msg Takes a string which guides the player what to input
	 * @return Returns char the player input
	 */
	public char getCharInput(String msg) {
		char letter;
		System.out.print(msg);
		letter = scStr.nextLine().charAt(0);
		return letter;
	}
	
	/**
	 * Method that returns a int input
	 * @param msg Takes a string which guides the player what to input
	 * @return Returns int the player input
	 */
	public int getIntInput(String msg) {
		int num;
		System.out.print(msg);
		num =  scInt.nextInt();
		return num;
	}
	
	/**
	 * Method that print outs dialog
	 * @param str Takes string the dialog
	 */
	public void printDialog(String str) {
		System.out.println(str);
	}
	
	/**
	 * Methods that prints out a line separator
	 * Commonly used in the end of chapters
	 */
	public void printSeparator() {
		System.out.println("---------------------------------------\n");
	}
}
