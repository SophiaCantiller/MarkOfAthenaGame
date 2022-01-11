/**
 * Collection of iterable classes
 * Mostly collection of alike data types like array of objects
 * @author Sophia Feona Cantiller.
 */
package com.athena.iterables;

/**
 * 
 * 
 * Iterator interface class that controls the queue of array objects
 * @author Sophia Feona Cantiller.
 *
 */
public interface Iterator {
	/**
	 * 
	 * @return Returns a random object from the array of objects
	 */
	public Object randomDraw();
	
	/**
	 * Checks if the drawn index is already on the list of drawn indexes
	 * @param index Takes an int the drawn index
	 * @return Returns boolean the result of the index param
	 */
	public boolean isIndexDrawn(int index);
	
	/**
	 * Adds the index param to the list of drawn indexes
	 * @param index Takes an int for the index
	 */
	public void addDrawnIndex(int index);
	
	/**
	 * Methods that moves the current index to its sibling index in the right
	 */
	public void nextObj();
	
	/**
	 * Methods that moves the current index for the drawn indexes to its sibling index in the right
	 */
	public void nextDraw();
	
	/**
	 * Resets the current index of the object array
	 */
	public void resetObj();
	
	/**
	 * Resets the current index of the drawn indexes
	 */
	public void resetDraw();
}
