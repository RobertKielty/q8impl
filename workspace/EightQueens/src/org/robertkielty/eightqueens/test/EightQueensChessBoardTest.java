/**
 * 
 */
package org.robertkielty.eightqueens.test;

import org.robertkielty.eightqueens.EightQueensChessBoard;
import org.robertkielty.eightqueens.EightQueensChessBoard.PositionStatus;

import junit.framework.TestCase;

/**
 * @author rkielty
 * 
 */
public class EightQueensChessBoardTest extends TestCase {
	EightQueensChessBoard q8cb;
	/**
	 * @param name
	 */
	public EightQueensChessBoardTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		q8cb = new EightQueensChessBoard(8);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link org.robertkielty.eightqueens.EightQueensChessBoard#QueensEightChessBoard(int)}.
	 */
	public final void testQueensEightChessBoard() {
		assertTrue(q8cb.placePiece(3,3));
		System.out.println(this.getName());
		System.out.println(q8cb.toString());
	}
	
	public final void testDuplicatePlacement(){
		
		System.out.println(this.getName());

		// Place a piece at 3,3
		System.out.println(q8cb.toString());
		Boolean result = q8cb.placePiece(3,3); 
		System.out.println(q8cb.toString());
		System.out.println(result);
		assertTrue(result);

		// Attempt to place at 3,3 though this should fail
		result = q8cb.placePiece(3,3); 
		System.out.println(q8cb.toString());
		System.out.println(result);
		assertFalse(result);
		
	}

	public final void testBoundaryPlacement(){
		
		int gridSize = q8cb.getSize();
		
		// Bottom left hand corner.
		q8cb.clearTheBoard();
		assertTrue(q8cb.placePiece(0,0));
		assertTrue(q8cb.getGrid()[0][0] == PositionStatus.OCCUPIED);
		
		for(int j=1 ; j < gridSize ; j++) 
			assertTrue(q8cb.getGrid()[0][j] == PositionStatus.UNSAFE);

		for(int i=1 ; i < gridSize ; i++)
			assertTrue(q8cb.getGrid()[i][0] == PositionStatus.UNSAFE);
		
		for(int i=1,j=1 ; (i < gridSize) && (j < gridSize) ; i++,j++)
			assertTrue(q8cb.getGrid()[i][j] == PositionStatus.UNSAFE);
		
		// Top Right Hand Corner
		q8cb.clearTheBoard();
		assertTrue(q8cb.placePiece(gridSize-1,gridSize-1));
		assertTrue(q8cb.getGrid()[gridSize-1][gridSize-1] == PositionStatus.OCCUPIED);
		
		for(int j=gridSize-2 ; j > 0 ; j--)
			assertTrue(q8cb.getGrid()[gridSize-1][j] == PositionStatus.UNSAFE);

		for(int i=0 ; i < gridSize-2; i++)
			assertTrue(q8cb.getGrid()[i][gridSize-1] == PositionStatus.UNSAFE);
		
		for(int i=gridSize-2,j=gridSize-2 ; (i >= 0) && (j >=0) ; i--,j--)
			assertTrue(q8cb.getGrid()[i][j] == PositionStatus.UNSAFE);

		// TODO Check that for correct setting of unsafe markers
		q8cb.clearTheBoard();
		assertTrue(q8cb.placePiece(0,q8cb.getGridSize()-1));
		assertTrue(q8cb.getGrid()[0][q8cb.getGridSize()-1] == PositionStatus.OCCUPIED);
		
		q8cb.clearTheBoard();
		assertTrue(q8cb.placePiece(q8cb.getGridSize()-1,0));
		assertTrue(q8cb.getGrid()[q8cb.getGridSize()-1][0] == PositionStatus.OCCUPIED);
	}

	public final void testOutOfBoundsPlacement(){
		int gridSize = q8cb.getGridSize();
		try {
			q8cb.placePiece(-1,-1);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		try {
			q8cb.placePiece(0,gridSize);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		try {
			q8cb.placePiece(gridSize,0);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		try {
			q8cb.placePiece(gridSize,gridSize);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}
