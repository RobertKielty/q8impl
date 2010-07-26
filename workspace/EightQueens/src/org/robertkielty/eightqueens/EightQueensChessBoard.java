package org.robertkielty.eightqueens;

/**
 * @author rkielty
 * 
 * The EightQueensChessBoard class implements a chess board to solve the QueensEight problem
 * see: <url>http://en.wikipedia.org/wiki/Eight_queens_puzzle</url> for details.
 * 
 * TODO : Inject the board Size using a DI mechanism 
 */
public class EightQueensChessBoard {
	
	public enum PositionStatus {OCCUPIED, UNSAFE, EMPTY}
		
	private PositionStatus board[][];   // two dimensional array that contains state of the board  
	
	private int size;					// Size of the chess board.
	
	private int count;					// Number of queens placed.
	
	/**
	 * ctr
	 */
	public EightQueensChessBoard(int s) {
		size = s;
		board = new PositionStatus[size][size];
		count = 0;
		clearTheBoard();
	}
	
	/**
	 * Attempt to place a Queen on the board specifying the column and row.
	 * @param col  
	 * @param row
	 * @return true if the placement was successful 
	 */
	public Boolean placePiece(int col, int row){

		if(isPlaceable(col,row)){
			board[col][row]=PositionStatus.OCCUPIED;
			count++;
			markAttackablePositions(col,row);
			return true;
		}
		return false;
	}
	/**
	 * Marks positions that are attackable from the position identified by (col,row) as taken.
	 * @param col - The column position of the Queen : 0 >= col < size  
	 * @param row - The row position of the Queen    : 0 >= row < size
	 */
	private void markAttackablePositions(int col, int row) {
		
		assert(col>=0);
		assert(col<size);

		assert(row<size);
		assert(row>=0);
		
		assert(board[col][row] == PositionStatus.OCCUPIED); // TODO : Good idea? Discuss at CR.
		
		// This column is now under attack
		for (int y=0; y<size;y++) 
			board[col][y] = PositionStatus.UNSAFE;

		// This row is now under attack
		for (int x=0; x < size; x++)
			board[x][row] = PositionStatus.UNSAFE;

		// Upper Right Diagonal : pre-increment x and y here?
		for (int x=col,y=row; x<size && y<size ; x++,y++)
			board[x][y] = PositionStatus.UNSAFE;
		
		// Lower Right Diagonal
		for (int x=col,y=row; x < size &&  y >= 0 ; x++,y--)
			board[x][y] = PositionStatus.UNSAFE;
		
		// Upper Left Diagonal
		for (int x=col,y=row; x >= 0 && y < size ; x--,y++)
			board[x][y] = PositionStatus.UNSAFE;

		// Lower Left Diagonal
		for (int x=col,y=row; x >= 0 && y >= 0 ; x--,y--)
			board[x][y] = PositionStatus.UNSAFE;
		
		board[col][row] = PositionStatus.OCCUPIED;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (int x=size-1; x >= 0; x--) {
			for (int y=0; y < size; y++) {
				switch (board[x][y]) {
				case UNSAFE:
					sb.append(" X ");
					break;
				case OCCUPIED:
					sb.append(" Q ");
					break;
				case EMPTY:
					sb.append(" _ ");
					break;
				default:
					break;
				} 
			}
			sb.append('\n');
		}
		return sb.toString();
	}
	/**
	 * 
	 * @param col
	 * @param row
	 * @throws IllegalArgumentException
	 * @return true if a piece can be placed here due to the position being empty and not under attack.
	 *         false if a position is under attack from a queen or is not empty.
	 *         
	 */
	private boolean isPlaceable(int col, int row) {

		if (row < 0 || row >= size) 
			throw new IllegalArgumentException(
					"isPlaceable : row " 
					+ row + "parameter out of bounds, must be between 0  and " 
					+ size);

		if (col < 0 || col >= size) 
			throw new IllegalArgumentException(
					"isPlaceable : col " 
					+ col + "parameter out of bounds, must be between 0  and " 
					+ size);
		
		if (board[col][row] == PositionStatus.UNSAFE 
				|| board[col][row] == PositionStatus.OCCUPIED)  
			return false;
		else 
			return true;
	}
	/**
	 * Removes all Queens from the Board.  
	 */
	public void clearTheBoard() {
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				board[i][j]=PositionStatus.EMPTY;	
			}
		}
		setCount(0);
	}

	public int getGridSize() {
		return size;
	}

	/**
	 * 
	 * @return Position
	 */
	public Position getNextSafePosition() {
		for(int col=0; col < size; col++ ){
			for(int row=0; row < size; row++ ){
				if (board[col][row] == PositionStatus.EMPTY)
					return new Position(col, row, board[col][row]);
			}
		}
		return null;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public PositionStatus[][] getGrid() {
		return board;
	}

	public void setGrid(PositionStatus[][] grid) {
		this.board = grid;
	}

}
