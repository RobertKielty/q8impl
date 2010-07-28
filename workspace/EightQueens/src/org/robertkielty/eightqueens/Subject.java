/**
 * 
 */
package org.robertkielty.eightqueens;

/**
 * @author rkielty
 * 
 */
public interface Subject {
	void registerObserver(Observer obs);
	void removeObserver(Observer obs);
	void notifyObserver(Solution sol);
}
