package v53.boardgames.game.crush;

import v53.boardgames.game.*;
import v53.boardgames.game.player.*;

/**
 * Crush game: place a piece on the same cell as your opponent.
 */
public class Crush implements IGame {
	
	public Player[] players() {
		Player[] players = new Player[2];
		players[0] = new IAPlayer("Black");
		players[1] = new HumanPlayer("White");
		return players;
	}

    @Override
    public void updatePlay(GameState state, Action action) {
        Board board = state.getBoard();
        final char playerChar = state.isBlack() ? 'B' : 'W';
        final char opponentChar = state.isBlack() ? 'W' : 'B';
        if (board.getContent(action.getLine(), action.getColumn()) == opponentChar) {
            System.out.println("This cell is occupied by your opponent: "
                    + (state.isBlack() ? "Black" : "White") + " wins!");
            state.setWinner(playerChar);
            state.setEnd(true);
        } else if (board.getContent(action.getLine(), action.getColumn()) == playerChar) {
            System.out.println("This cell is occupied by you: "
                    + (state.isBlack() ? "White" : "Black") + " wins!");
            state.setWinner(opponentChar);
            state.setEnd(true);
        } else {
            board.setContent(action.getLine(), action.getColumn(), playerChar);
            state.current=(state.current + 1 ) %2 ;
        }
    }
}
