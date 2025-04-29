package lab07;

public class GameLogic {
	private Player currentPlayer;
	private Player otherPlayer;

	public GameLogic(Player a, Player b) {
		this.currentPlayer = a;
		this.otherPlayer = b;
	}

	// returns current player as a player and switches players after that
	public Player getCurrentPlayer() {
		Player temp = currentPlayer;
		switchPlayer();
		return temp;

	}

	// changes current player to other player
	public void switchPlayer() {
		Player temp = currentPlayer;
		currentPlayer = otherPlayer;
		otherPlayer = temp;
	}

	// checks all win conditons
	public boolean checkWin(GameBoard board, char symbol) {
		char[][] b = board.getBoard();
		for (int row = 0; row < 3; row++) {
			// checks all row wins
			if (b[row][0] == symbol && b[row][1] == symbol && b[row][2] == symbol) {

				return true;

			}
		}
		for (int col = 0; col < 3; col++) {
			// checks all column wins
			if (b[0][col] == symbol && b[1][col] == symbol && b[2][col] == symbol) {
				return true;
			}
		}
		// checks the diagonal wins
		if (b[0][0] == symbol && b[1][1] == symbol && b[2][2] == symbol) {
			return true;
		}
		if (b[0][2] == symbol && b[1][1] == symbol && b[2][0] == symbol) {
			return true;
		}
		return false;
	}

	// checks draws and resets the board
	public boolean checkDraw(GameBoard board) {
		char[][] b = board.getBoard();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (b[row][col] == ' ') {// if there is an open space then there is no draw
					return false;
				}
			}
		}
		return true;
	}
}
