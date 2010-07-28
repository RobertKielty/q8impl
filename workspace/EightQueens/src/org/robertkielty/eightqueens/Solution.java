package org.robertkielty.eightqueens;

public class Solution {

	private String boardString;
	private int queensPlaced;
	private long timeTaken;

	public Solution(final String board,final int count,final long timeTaken) {
		this.boardString = board;
		this.queensPlaced = count;
		this.timeTaken = timeTaken;
	}	
	/**
	 * @return the boardString
	 */
	public String getBoardString() {
		return boardString;
	}
	/**
	 * @param boardString the boardString to set
	 */
	public void setBoardString(final String boardString) {
		this.boardString = boardString;
	}
	/**
	 * @return the queensPlaced
	 */
	public int getQueensPlaced() {
		return queensPlaced;
	}
	/**
	 * @param queensPlaced the queensPlaced to set
	 */
	public void setQueensPlaced(final int queensPlaced) {
		this.queensPlaced = queensPlaced;
	}
	/**
	 * @return the timeTaken
	 */
	public long getTimeTaken() {
		return timeTaken;
	}
	/**
	 * @param timeTaken the timeTaken to set
	 */
	public void setTimeTaken(final long timeTaken) {
		this.timeTaken = timeTaken;
	}	
}
