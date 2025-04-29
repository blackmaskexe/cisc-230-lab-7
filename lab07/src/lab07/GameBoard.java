package lab07;

public class GameBoard {
	private char[][] board;

	public GameBoard() {
		this.board = new char[3][3];
		// creating a blank 3x3 board (having 3 rows and columns in the 2d array)
		for (int row = 0; row < 3; row++) {
			// looping through the inner array, and adding 3 blanks:
			for (int col = 0; col < 3; col++) {
				board[row][col] = ' ';
			}
		}
	}

	// check if a cell is empty
	public boolean isCellEmpty(int row, int col) {
		if (board[row][col] == ' ') {
			return true;
		}
		return false;
	}

	// places the current symbol and returns if it worked
	public boolean placeMove(int row, int col, char symbol) {
		if (isCellEmpty(row, col)) {
			board[row][col] = symbol;
			return true;
		}
		return false;
	}

	// sets all indexes to ' '
	public void resetBoard() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = ' ';

			}
		}
	}

	// returns copy of the board
	public char[][] getBoard() {
		// returning a deep copy of this.board:
		char[][] copyBoard = new char[3][3];

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				copyBoard[row][col] = board[row][col];
			}
		}

		return copyBoard;

	}

}
