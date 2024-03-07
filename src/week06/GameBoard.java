package week06;

public class GameBoard {


	GameBoard() {

	}
	
	public void display(String[][] gameState) {
		System.out.println("  0   1   2 ");
		System.out.println("0 " + gameState[0][0] + " | " + gameState[1][0] + " | " + gameState[2][0] + " ");
		System.out.println(" ---+---+---");
		System.out.println("1 " + gameState[0][1] + " | " + gameState[1][1] + " | " + gameState[2][1] + " ");
		System.out.println(" ---+---+---");
		System.out.println("2 " + gameState[0][2] + " | " + gameState[1][2] + " | " + gameState[2][2] + " ");
	}

}
