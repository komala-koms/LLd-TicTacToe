import java.util.*;

public class Game {
	int curent_player_turn = 1;
	Player plyr1, plyr2;
	Board board;

	Scanner sc = new Scanner(System.in);

	public Game() {
		System.out.println("Enter size of tic-tac-toe");
		int size = sc.nextInt();
		board = new Board(size);
		plyr1 = new Player(1, "Ashok", -1);
		plyr2 = new Player(2, "Komala", 1);
	}

	public Player getPlayer() {
		if (curent_player_turn == 1) {
			curent_player_turn = 2;
			return plyr2;
		} else {
			curent_player_turn = 1;
			return plyr1;
		}
	}

	public boolean isTerminalState() {
		return Board.empty_cells == 0;
	}

	public boolean check_for_win(Player player, int row, int col) {
		int id = player.getSymbol();
		boolean rows = board.check_rows(id, row);
		boolean cols = board.check_colums(id, col);

		boolean diag = board.check_diagnol(id);
		boolean rev_diag = board.check_rev_diagnol(id);
		if (rows || cols || diag || rev_diag)
			return true;
		return false;

	}

	public void startGame() {
		int row, col;
		while (!isTerminalState()) {
			Player player = getPlayer();
			do {
				System.out.println("Player - "+player.getId()+" turn, Symbol : "+player.getSymbol());
				board.getBoardState();
				System.out.println("Enter row");
				row = sc.nextInt();
				System.out.println("Enter column");
				col = sc.nextInt();
			} while (!board.validate_row_and_col(row, col));
			board.makeMove(player, row, col);
			if (check_for_win(player, row, col)) {
				board.getBoardState();
				System.out.println(player.getName() + " is the winner");
				break;
			}

		}
		if(isTerminalState())
		{
			System.out.println("Game is Tied");
		}
	}
}
