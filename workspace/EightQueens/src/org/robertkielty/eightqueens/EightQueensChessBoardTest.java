/**
 * 
 */
package org.robertkielty.eightqueens;

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
		System.out.println(q8cb.toString());
		Boolean result = q8cb.placePiece(3,3); // Have already place a piece at 3,3
		System.out.println(q8cb.toString());
		System.out.println(result);
		assertTrue(result);
		result = q8cb.placePiece(3,3); // Have already place a piece at 3,3
		System.out.println(q8cb.toString());
		System.out.println(result);
		assertFalse(result);
		
	}

	public final void testBoundaryPlacement(){
		assertTrue(q8cb.placePiece(0,0));
	}

	public final void testOutOfBoundsPlacement(){
		try {
			q8cb.placePiece(-1,3);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		try {
			assertFalse(q8cb.placePiece(1,8));
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		try {
			assertFalse(q8cb.placePiece(8,8));
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	/**
	 * Test method for {@link org.robertkielty.eightqueens.EightQueensChessBoard#placePiece(int, int)}.
	 */
//	public final void testPlacePiece() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.robertkielty.eightqueens.EightQueensChessBoard#toString()}.
//	 */
//	public final void testToString() {
//		fail("Not yet implemented"); // TODO
//	}

}
