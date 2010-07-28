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
public class BruteForceImpl implements Algorithm, Subject {

	transient private Observer obs;
	/* (non-Javadoc)
	 * @see org.robertkielty.eightqueens.Algorithm#exucute(org.robertkielty.eightqueens.EightQueensChessBoard)
	 */
	@Override
	public void execute(final EightQueensChessBoard eqb) {
		
		Boolean solutionNotFound = true;
		
		final long startTime = System.currentTimeMillis();
		
		long endTime = 0; // NOPMD by rkielty on 28/07/10 00:19
		long duration;
		
		
		while(solutionNotFound) {
			
			findSolution(eqb);
			
			if (eqb.getCount()==eqb.getGridSize()){
				
				endTime = System.currentTimeMillis();
				solutionNotFound = false;
				
			} else {
				
				final long lapTime = System.currentTimeMillis();
				final long iterationTime = lapTime - startTime ;
				
				Solution partial = new Solution(eqb.toString(), eqb.getCount() , iterationTime);

				notifyObserver(partial);
				
				eqb.clearTheBoard();
				
				partial = null; // NOPMD by rkielty on 28/07/10 00:17
			}
			
		}
		
		duration = endTime - startTime;
		
		final Solution fullSolution = new Solution(eqb.toString(), eqb.getCount() , duration);
		notifyObserver(fullSolution);
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

	@Override
	public void registerObserver(final Observer obs) {
		// TODO Auto-generated method stub
		this.obs = obs;
	}

	@Override
	public void notifyObserver(final Solution solution) {
		obs.update(solution);
	}

	@Override
	public void removeObserver(final Observer observer) {
		obs=null;
	}
	
}
