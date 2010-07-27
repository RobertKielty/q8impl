/**
 * 
 */
package org.robertkielty.eightqueens;

import java.util.Random;

/**
 * @author rkielty
 * Sample algorithm to find solutions for the Eight Queens Problem.
 * 
 */
public class BruteForceImpl implements Algorithm {

	/* (non-Javadoc)
	 * @see org.robertkielty.eightqueens.Algorithm#exucute(org.robertkielty.eightqueens.EightQueensChessBoard)
	 */
	@Override
	public void execute(final EightQueensChessBoard eqb) {
		
		Boolean solutionNotFound = true;
		
		final long startTime = System.currentTimeMillis();
		
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
				final long lapTime = System.currentTimeMillis();
				final long iterationTime = startTime - lapTime;
				
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

	private void findSolution(final EightQueensChessBoard eqb){
		final Random generator = new Random();

		// Pick a starting position at random to place the first piece.
		final int col = generator.nextInt( eqb.getGridSize() );
		final int row = generator.nextInt( eqb.getGridSize() );
		eqb.placePiece(col, row);

		// Iterate over the safe positions and add queens when next safe position found
		for (int i=0; i < eqb.getGridSize(); i++ ){
			Position pos = eqb.getNextSafePosition();
			eqb.placePiece(pos.getCol(), pos.getRow());
			pos=null;
		}
	}
}
