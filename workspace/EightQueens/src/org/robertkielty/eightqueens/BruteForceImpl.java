/**
 * 
 */
package org.robertkielty.eightqueens;

import java.util.Random;

/**
 * @author rkielty
 *
 */
public class BruteForceImpl implements Algorithm {

	int [][]  starting_positions;
	/* (non-Javadoc)
	 * @see org.robertkielty.eightqueens.Algorithm#exucute(org.robertkielty.eightqueens.EightQueensChessBoard)
	 */
	@Override
	public void execute(EightQueensChessBoard eqb) {
		Boolean solutionNotFound = true;
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		long duration;
		int iterations = 0;
		while(solutionNotFound) {
			
			iterations ++;

			findSolution(eqb);
			
			if (eqb.getCount()==eqb.getGridSize()){
				endTime = System.currentTimeMillis();
				solutionNotFound = false;
			} else {
				long lapTime = System.currentTimeMillis();
				long iterationTime = startTime - lapTime;
				System.out.println(eqb.getCount() +" queens in "+ iterationTime + "ms");
				System.out.println(eqb.toString());
				eqb.clearTheBoard();
			}
			
		}
		
		duration = startTime - endTime;
		
		System.out.println("Found the following solution in " + duration + "ms");
		System.out.println("using " + iterations + " attempts");
		System.out.println(eqb.toString());
	}

	private void findSolution(EightQueensChessBoard eqb){
		Random generator = new Random();

		// Pick a starting position at random to place the first piece.
		int col = generator.nextInt( eqb.getGridSize() );
		int row = generator.nextInt( eqb.getGridSize() );
		eqb.placePiece(col, row);

		// Iterate over the safe positions and add queens when next safe position found
		int i=0;
		for (; i < eqb.getGridSize(); i++ ){
			Position p = eqb.getNextSafePosition();
			if (p == null)
				break;
			eqb.placePiece(p.getCol(), p.getRow());
			p=null;
		}
	}
}
