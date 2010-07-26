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
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public PositionStatus getStatus() {
		return status;
	}
	public void setStatus(PositionStatus status) {
		this.status = status;
	}
	int col;
	int row;	
	PositionStatus status;
	public Position(int c,int r, PositionStatus status) {
		setCol(c);
		setRow(r);
		setStatus(status);
	}
}
