//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  Tic Tac Toe Game - Lab
// Java Week 06 Lab  
//
package week06;

import java.util.Scanner;

public class Week06TicTacToeLab {

	// This Lab requires you to program a simple game of Tic Tac Toe
	//
	// 		 Note:  there are many ways to implement this game.  Use what 
	//		  		you have already learned.  You have the tools to implement
	//		  		this game.  
	//
	// Rules:  
	//		- Tic Tac Toe is a 2-player game played on a 3x3 grid.  
	//
	//		- One player usually plays "X"s and the other player plays "O"s.
	//
	// 		- In our version of the game, "X"s will always start.
	//
	//		- Players will alternate turns.
	//
	// 		- The game will end when one of the conditions is true:
	//				1. A player gets three squares in a row 
	//				2. A player gets three squares in a column
	//				3. A player gets three squares in either diagonal
	//				4. Every square is filled in, but no player has achieved 
	//					conditions 1,2, or 3 as described above --> A Draw!
	//
	//		- A player can win on turn 5, 6, 7, 8, or 9 (start checking for winners on or before turn 5)
	//
	//		- Error checking of input is not necessary here, but will make this game much more
	//				robust.  If you choose to implement this, get the game working first, and then
	//				add a check of the input to make sure that it's an Integer from 1 to 9.
	//
	//		- Use the Scanner to input the users choice of square -- one suggestion is  
	//				to create numbers within the square, and then have the user choose 
	//				that integer (1-9) to choose the location.
	//
	//		- One way to display the game board would be as follows:
	//				+---+---+---+       to		+---+---+---+		+---+---+---+		+---+---+---+
	//				| 1 | 2 | 3 |	   find		|---|---|---|		| | | | | | |		| \ |   | / |
	//				+---+---+---+	   a win	+---+---+---+		+---+---+---+		+---+---+---+
	//				| 4 | 5 | 6 |	-- look-->	|---|---|---|	&	| | | | | | |   & 	|   | X |   |
	//				+---+---+---+	 at these	+---+---+---+		+---+---+---+		+---+---+---+
	//				| 7 | 8 | 9 |	8 patterns	|---|---|---|		| | | | | | |		| / |   | \ |
	//				+---+---+---+		        +---+---+---+		+---+---+---+		+---+---+---+
		
		
	// Start with these steps:
	//
	//		1. Create a class with a main method -- this Lab can be implemented in just one class.
	//				
	//				Alternatively, you could create an object with it's own methods. 
	//				(e.g. GameBoard.java)
	//
	//		2. You will need to declare a gameBoard.  
	//
	//				As shown above, Tic Tac Toe is played on a 3x3 grid that has 9 spaces. 
	//
	//					a. One suggestion is to create an array of length 9 to represent the board:
	//
	//						For example:  String[] gameBoard = new String[9]; 
	//
	//							i. Just remember that arrays are 0 based, so to access the grid, 
	//							the index would go from 0-8.  
	//
	//							ii. Wins can occur in 8 ways (see above).
	//								For example: A horizontal win would be found by 
	//								looking at the contents of: 
	//									gameBoard[0] & gameBoard[1] & gameBoard[2] 
	//									gameBoard[3] & gameBoard[4] & gameBoard[5] 
	//									gameBoard[6] & gameBoard[7] & gameBoard[8] 
	//
	//					b. Another option for the gameBoard would be a 2d array -- This option might be
	//						is a bit more challenging!  
	//
	//						For example:  String[][] gameBoard = new String[3][3];
	//					
	//							i. Just remember that arrays are 0 based, so to access the grid, 
	//							the index would go from 0-2 in two directions.  
	//
	//							ii. Wins can occur in 8 ways.  A horizontal win would be comparing:  
	//									gameBoard[0][0] & gameBoard[0][1] & gameBoard[0][2] 
	// 
	//		3.  Implement the rules as listed above.  
	//
	//		4.  You might want to have the following methods:
	//					a. display() -- to print the gameBoard
	//					b. checkWinStatus() -- to check if a player has won
	//					c. initialize() -- to set up your new gameBoard
	//			
	//		5.  Reminder:  There is no one way to implement this game.
	//		
	//	
	
	// START YOUR IMPLEMENTATION BELOW THIS LINE
private final static int ROW_SIZE = 3;
private final static int COL_SIZE = 3;

private static String[][] gameState;
private static String player = "X";

	public static void main(String[] args) {
		
		GameBoard gameBoard = new GameBoard();
		boolean playing = true;

		
		gameState = new String[ROW_SIZE][COL_SIZE];
		initialize(gameState);
		
		System.out.println("TIC TAC TOE");
		
		gameBoard.display(gameState);
		
		// Create a game loop
		while(playing) {
			playerChoice();
			gameBoard.display(gameState);
			playing = checkForWin();
			nextPlayer();
		}
		
	}
	
	private static boolean checkForWin() {
		boolean noWinner = true;
		boolean gameBoardFull = true;
		
		isFull:
		for (int i = 0; i < ROW_SIZE; i++) {
			for (int j = 0; j < COL_SIZE; j++) {
				if (gameState[i][j] == " ") {
					gameBoardFull = false;
					break isFull;
				}
			}
		}
		

		
		for (int i = 0; i < ROW_SIZE; i++) {
			if (gameState[0][i] == player && gameState[1][i] == player && gameState[2][i] == player) {
				noWinner = false;
			}
		}
		for (int j = 0; j < COL_SIZE; j++) {
			if (gameState[j][0] == player && gameState[j][1] == player && gameState[j][2] == player) {
				noWinner = false;
			}
		}
		if (gameState[0][0] == player && gameState[1][1] == player && gameState[2][2] == player) {
			noWinner = false;
		}
		if (gameState[2][0] == player && gameState[1][1] == player && gameState[0][2] == player) {
			noWinner = false;
		}
		if (noWinner && gameBoardFull) {
			System.out.println("CAT GAME!");
			return false;
			
		} else if (!noWinner) {
			System.out.println(player + "s WIN!");
		}
		return noWinner;
		
	}

	private static void nextPlayer() {
		if (player == "X") {
			player = "O";
		} else if (player == "O") {
			player = "X";
		}
	}

	private static String[][] initialize(String[][] state){
		for (int i = 0; i < COL_SIZE; i++) {
			for (int j = 0; j < ROW_SIZE; j++) {
				state[i][j] = " ";
			}
		}
		return state;
	}
	
	
	
	private static void move(int row, int col, String playerMark){
		gameState[row][col] = playerMark;
	}
	
	
	
	private static void playerChoice() {
		Scanner scanner = new Scanner(System.in);
		int row,col;

		// Asks the user for the next input

		do {
			System.out.print(player + ": which row? ");
			row = scanner.nextInt();
			while (!(row == 0 || row == 1 || row == 2)) {
				System.out.print("Invalid selection! Please select a valid row. ");
				row = scanner.nextInt();
			}
			System.out.print(player + ": which column? ");
			col = scanner.nextInt();
			while 	(!(col == 0 || col == 1 || col == 2)) {
				System.out.println("Invalid selection! Please select a valid column. ");
				col = scanner.nextInt();
			}
			
			// Checks to see if space is already taken and asks player to select again if it is.
		} while(isSpaceTaken(row,col));
		
		
		
		move(row, col, String.valueOf(player));
	}
	
	
	
	private static boolean isSpaceTaken(int row, int col) {
		if (gameState[row][col] == "X" || gameState[row][col] == "O") {
			System.out.println("That space is already taken. Please try again.");
			return true;
		} else {
			return false;
		}
	}


}