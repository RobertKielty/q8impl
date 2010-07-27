package org.robertkielty.eightqueens;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Goal to  place 8 queens on  this chess board so that al are safe. 
		EightQueensChessBoard eqb = new EightQueensChessBoard(getBoardSize());
		
		// TODO : Could use DI to inject an algorithm here.
		BruteForceImpl bfAlgorithm = new BruteForceImpl();
		bfAlgorithm.execute(eqb);
	}

	private static int getBoardSize() {
		// TODO : Change to command-line/config-file reading/DI data injection. 
		return 8;
	}

}
