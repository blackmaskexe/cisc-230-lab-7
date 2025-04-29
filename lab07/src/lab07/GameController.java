package lab07;

public class GameController {
	protected GameLogic logic;
	protected GameBoard board;
	private TicTacToeGUI gui;
	protected int xScore = 0;
	protected int oScore = 0;

	public GameController(Player player1, Player player2) {
		logic = new GameLogic(player1, player2);
		board = new GameBoard();
		gui = new TicTacToeGUI(this);
	}

	public void cellClick(int row, int col) {
		Player temp = logic.getCurrentPlayer();
		this.board.placeMove(row, col, temp.getSymbol());// place move

		// after every move, check wins and draws
		if (logic.checkWin(board, 'x')) {
			xScore++;
			resetBoard();
		}
		if (logic.checkWin(board, 'o')) {
			oScore++;
			resetBoard();
		}
		if (logic.checkDraw(board) == true) {
			resetBoard();
		}
		gui.updateScores(this);
		gui.updateBoard(board);
	}

	// resets/ updates the board/gui
	public void resetBoard() {
		board.resetBoard();
		gui.updateBoard(board);
	}

//starts game
	public static void main(String[] args) {
		Player one = new HumanPlayer("player 1", 'x');
		Player two = new HumanPlayer("player 2", 'o');
		GameController controller = new GameController(one, two);
	}
}
