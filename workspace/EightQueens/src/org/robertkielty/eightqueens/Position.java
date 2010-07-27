package org.robertkielty.eightqueens;

import org.robertkielty.eightqueens.EightQueensChessBoard.PositionStatus;
/**
 * 
 * @author rkielty
 * Describes a position on a two dimensional  
 */
public class Position {
	public int getCol() {
		return col;
	}
	public void setCol(final int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(final int row) {
		this.row = row;
	}
	public PositionStatus getStatus() {
		return status;
	}
	public void setStatus(final PositionStatus status) {
		this.status = status;
	}
	private int col;
	private int row;	
	private PositionStatus status;
	public Position(final int col,final int row, final PositionStatus status) {
		this.col = col;
		this.row = row;
		this.status = status;
	}
	public Position() {
		// do nothing
	}
}
