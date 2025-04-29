package lab07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI {
	private JFrame frame;
	private static JButton[][] buttons;
	private GameController controller;
	private static JLabel scoreX;
	private static JLabel scoreO;

	public TicTacToeGUI(GameController gameController) {
		this.controller = gameController;// uses gameboard array
		// sets the frame info
		frame = new JFrame("Tic Tac Toe");// top of window namw
		frame.setLayout(new GridLayout(4, 3));// 3x3 for the buttons then scores amd reset
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[3][3];// sets the button array

		for (int row = 0; row < 3; row++) {// loops through rows
			for (int col = 0; col < 3; col++) {// loops through cols
				final int r = row;// sets as final so we can reuse action listener
				final int c = col;
				buttons[row][col] = new JButton("");// sets all buttons to blank
				buttons[row][col].setFocusPainted(false);
				buttons[row][col].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));// sets
				// and makes font bigger
				buttons[row][col].addActionListener(new ActionListener() {// when clicked
					public void actionPerformed(ActionEvent e) {
						controller.cellClick(r, c);// place move
					}
				});
				frame.add(buttons[row][col]);// adds the buttons to the frame
			}
		}

		// player scores
		scoreX = new JLabel("X's Score: " + controller.xScore);// gets score from the controller
		scoreO = new JLabel("O's Score: " + controller.oScore);
		frame.add(scoreX);// adds to frame
		frame.add(scoreO);

		// add reset button
		JButton resetButton = new JButton("reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.resetBoard();// calls reset board form controller which clears and updates the view/array of
										// the board
			}
		});
		frame.add(resetButton, 10);// adds the button and sets its location in the grid

		frame.setVisible(true);// sets visible
	}

	// used to updoate the gui board from the GameBoard array
	public void updateBoard(GameBoard board) {
		for (int row = 0; row < 3; row++) {// loops through rows
			for (int col = 0; col < 3; col++) {// loops through cols
				buttons[row][col].setText(Character.toString(board.getBoard()[row][col]));// takes char from the game
																							// board array and puts the
																							// text onto the gui
				if (!board.isCellEmpty(row, col)) {
					buttons[row][col].setEnabled(false);// if the square is taken, make it disbled
				} else {
					buttons[row][col].setEnabled(true);// if its empty enable it
				}
			}
		}

	}

	// used to update the text of the score boxes
	public void updateScores(GameController controller) {
		// updates the text for the scores
		scoreX.setText("X's Score: " + controller.xScore);
		scoreO.setText("O's Score: " + controller.oScore);
	}

}
