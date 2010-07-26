/**
 * 
 */
package org.robertkielty.queenseight;

import junit.framework.TestCase;

/**
 * @author rkielty
 *
 */
public class QueensEightChessBoardTest extends TestCase {
	QueensEightChessBoard q8cb;
	/**
	 * @param name
	 */
	public QueensEightChessBoardTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link org.robertkielty.queenseight.QueensEightChessBoard#QueensEightChessBoard(int)}.
	 */
	public final void testQueensEightChessBoard() {

		q8cb = new QueensEightChessBoard(8);

		assertTrue(q8cb.placePiece(3,3));
		System.out.println(q8cb.toString());
		assertFalse(q8cb.placePiece(3,3));
		System.out.println(q8cb.toString());
		//assertFalse(q8cb.placePiece(-1,3));
		assertFalse(q8cb.placePiece(1,8));
		System.out.println(q8cb.toString());
		assertFalse(q8cb.placePiece(8,8));
		System.out.println(q8cb.toString());
		
	}

	/**
	 * Test method for {@link org.robertkielty.queenseight.QueensEightChessBoard#placePiece(int, int)}.
	 */
//	public final void testPlacePiece() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.robertkielty.queenseight.QueensEightChessBoard#toString()}.
//	 */
//	public final void testToString() {
//		fail("Not yet implemented"); // TODO
//	}

}
