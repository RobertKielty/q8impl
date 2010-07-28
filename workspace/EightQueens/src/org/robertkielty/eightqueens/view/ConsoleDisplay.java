package org.robertkielty.eightqueens.view;

import org.robertkielty.eightqueens.Application;
import org.robertkielty.eightqueens.Observer;
import org.robertkielty.eightqueens.Solution;
import org.robertkielty.eightqueens.Subject;

public class ConsoleDisplay implements Observer, SolutionDisplay {
	private transient Solution solution;
	
	public ConsoleDisplay(final Subject algo) {
		algo.registerObserver(this);
	}
	
	@Override
	public void display() {
		if (solution.getQueensPlaced() == Application.getBoardSize()) {
			System.out.println("Full solution : "  
					+  Application.getBoardSize() 
					+ " queens placed."); // NOPMD by rkielty on 28/07/10 02:35
		} else {
			System.out.println("Part solution : "  // NOPMD by rkielty on 28/07/10 02:36
					+ solution.getQueensPlaced() 
					+ " queens placed." );	
		}
		System.out.println("Elapsed time  : " + solution.getTimeTaken() +"ms");
		System.out.println(solution.getBoardString()); // NOPMD by rkielty on 28/07/10 02:36
	}

	@Override
	public void update(final Solution sol) {
		this.solution =  sol;
		display();
	}
}
