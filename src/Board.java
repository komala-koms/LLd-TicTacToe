import java.math.*;

public class Board {
	int size;
	int[][] matrix;
	static int empty_cells;

	public Board(int size) {
		this.size = size;
		this.matrix = new int[size][size];
		empty_cells = size * size;
	}

	public boolean validate_row_and_col(int row, int col) {
		if (row < 0 || row >= this.size || col < 0 || col >= this.size) {
			System.out.print("enter a valid moce");
			return false;
		}
		if (this.matrix[row][col] != 0) {
			System.out.println("already occupied");
			return false;
		}
		return true;
	}

	// -3 --> count -- > win
	public boolean check_rows(int symbol, int row) {
		for (int i = 0; i < this.matrix.length; i++) {
			if (matrix[row][i] != symbol)
				return false;
		}
		return true;
	}

	public boolean check_colums(int symbol, int col) {
		for (int i = 0; i < this.matrix.length; i++) {
			if (matrix[i][col] != symbol)
				return false;
		}
		return true;
	}

	public boolean check_diagnol(int symbol) {
		for (int i = 0; i < this.matrix.length; i++) {
			if (matrix[i][i] != symbol)
				return false;
		}
		return true;
	}

	public boolean check_rev_diagnol(int symbol) {
		for (int i = 0; i < this.matrix.length; i++) {
			if (matrix[i][this.size - i - 1] != symbol)
				return false;
		}
		return true;
	}

	public void makeMove(Player player, int row, int col) {
		this.matrix[row][col] = player.getSymbol();
		this.empty_cells -= 1;
	}

	public boolean terminal_stage() {
		return empty_cells == 0;
	}

	public void getBoardState() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
