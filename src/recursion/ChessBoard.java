// import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.HashMap;
package recursion;

public class ChessBoard {
	private int board[][];
	private int boardSize = 0;

	public ChessBoard(int size) {
		board = new int[size][size];
		boardSize = size;
	}

	/**
	 * Start solving nQueens starting with 0 col 0 row
	 * 
	 * @return boolean. false if no solution exists else otherwise
	 */
	public boolean solveNQueens() {
		if (boardSize == 2 || boardSize == 3)
			return false;

		boolean solvableBoard = nQueens(board, 0);
		if (solvableBoard) {
			printBoard();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Goes over board recursively and iterates over rows to find a solution
	 * 
	 * @param board 2D array board
	 * @param col   current column index
	 * @return boolean. false if no solution exists else otherwise
	 */
	private boolean nQueens(int[][] board, int col) {
		if (col >= boardSize)
			return true;

		for (int row = 0; row < boardSize; row++) {
			if (isPositionSafe(board, row, col)) {
				board[row][col] = 1;

				if (nQueens(board, col + 1) == true)
					return true;

				board[row][col] = 0;
			}
		}

		return false;
	}

	/**
	 * Checks whether a position is attacked by other queens
	 * 
	 * @param board the 2D board array
	 * @param row   current row index
	 * @param col   current column index
	 * @return boolean if position is safe
	 */
	private boolean isPositionSafe(int[][] board, int row, int col) {
		int rowCopy = row;
		int colCopy = col;

		for (int i = 0; i < boardSize; i++)
			if (board[row][i] == 1)
				return false;

		for (int i = 0; i < boardSize; i++)
			if (board[i][col] == 1)
				return false;

		// First Diagonal \
		for (int i = 0; i < boardSize; i++) {
			rowCopy--;
			colCopy--;
			if (rowCopy < 0 || colCopy < 0)
				break;
			if (board[rowCopy][colCopy] == 1)
				return false;
		}
		rowCopy = row;
		colCopy = col;
		for (int i = 0; i < boardSize; i++) {
			rowCopy++;
			colCopy++;
			if (rowCopy == boardSize || colCopy == boardSize)
				break;
			if (board[rowCopy][colCopy] == 1)
				return false;
		}
		rowCopy = row;
		colCopy = col;

		// Second Diagonal /
		for (int i = 0; i < boardSize; i++) {
			rowCopy--;
			colCopy++;
			if (rowCopy < 0 || colCopy == boardSize)
				break;
			if (board[rowCopy][colCopy] == 1)
				return false;
		}
		rowCopy = row;
		colCopy = col;
		for (int i = 0; i < boardSize; i++) {
			rowCopy++;
			colCopy--;
			if (rowCopy == boardSize || colCopy < 0)
				break;
			if (board[rowCopy][colCopy] == 1)
				return false;
		}

		return true;
	}

	/**
	 * Prints the board to console
	 */
	public void printBoard() {
		for (int i = 0; i < boardSize; i++) {
			if (i < boardSize)
				System.out.println("=================");
			for (int j = 0; j < boardSize; j++) {
				System.out.print("| " + board[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("=================");
		System.out.println();
	}

	/**
	 * Returns board
	 * 
	 * @return 2D array board
	 */
	public int[][] getBoard() {
		return this.board;
	}
}