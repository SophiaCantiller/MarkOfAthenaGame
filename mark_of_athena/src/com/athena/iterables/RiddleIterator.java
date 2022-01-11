/**
 * Collection of iterable classes
 * Mostly collection of alike data types like array of objects
 * @author Sophia Feona Cantiller.
 */
package com.athena.iterables;

/**
 * 
 * 
 * RiddleIterator, controller for the riddle collection
 * @author Sophia Feona Cantiller.
 *
 */
public class RiddleIterator implements Iterator {
	
	/**
	 * Riddles array
	 */
	private Riddle[] myRiddles;
	
	/**
	 * Int array of drawn indexes
	 */
	private int[] drawnIndexes;
	/**
	 * Current riddle index
	 */
	private int index;
	/**
	 * Current drawn index
	 */
	private int drawnIndex;
	
	/**
	 * Constructor
	 * @param myRiddles Takes an array of riddles
	 */
	public RiddleIterator(Riddle[] myRiddles) {
		this.myRiddles = myRiddles;
		this.index = 0;
		this.drawnIndexes = new int[3];
		this.drawnIndex = 0;
	}
	
	@Override
	public Object randomDraw() {
		int drawnIndex = (int)Math.floor(Math.random()*(19-0+1)+0);
		if(!isIndexDrawn(drawnIndex)) {
			addDrawnIndex(drawnIndex);
			return myRiddles[drawnIndex];
			
		} else {
			return randomDraw();
		}
		
	}

	@Override
	public void addDrawnIndex(int index) {
		drawnIndexes[drawnIndex] = index;
	}
	
	@Override
	public boolean isIndexDrawn(int index) {
		for(int drawnIndex : drawnIndexes) {
			if(drawnIndex == index) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void nextObj() {
		if(index++ < myRiddles.length) {
			index++;
		} else {
			resetObj();
		}
	}

	@Override
	public void nextDraw() {
		if(drawnIndex++ < drawnIndexes.length) {
			index++;
		} else {
			index = 0;
		}
		
	}

	@Override
	public void resetObj() {
		index = 0;
		
	}

	@Override
	public void resetDraw() {
		drawnIndex = 0;
	}
}
