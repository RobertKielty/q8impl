package org.robertkielty.eightqueens;

import org.robertkielty.eightqueens.view.*;
/**
 * Goal to place 8 queens on this chess board so that none can be taken by each other.
 * @author rkielty
 *
 */
public class Application {

	final static private EightQueensChessBoard EQB = new EightQueensChessBoard(getBoardSize());
	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		 
		// TODO : Could use DI to inject an algorithm here.

		final BruteForceImpl bfAlgorithm = new BruteForceImpl();
		
		@SuppressWarnings("unused")
		final ConsoleDisplay solOutput = new ConsoleDisplay(bfAlgorithm);
		
		bfAlgorithm.execute(EQB);
	}

	public static int getBoardSize() {
		// TODO : Change to command-line/config-file reading/DI data injection. 
		return 8;
	}
}
