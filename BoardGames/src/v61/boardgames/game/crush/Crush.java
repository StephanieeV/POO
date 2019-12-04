package v61.boardgames.game.crush;

import java.util.HashSet;
import java.util.Set;

import v61.boardgames.action.Play;
import v61.boardgames.game.Board;
import v61.boardgames.game.Game;
import v61.boardgames.game.GameState;
import v61.boardgames.game.Piece;
import v61.boardgames.player.HumanPlayer;
import v61.boardgames.player.IAPlayer;
import v61.boardgames.player.Player;

/**
 * Crush game: place a piece on the same cell as your opponent.
 */
public class Crush extends Game {

    /**
     * Constructor.
     */
    public Crush() {
        super(2);
        players[0] = new IAPlayer("Black");
        players[1] = new HumanPlayer("White");
    }

    public Set<Piece> initPieces(Player p){
    	Set<Piece> set = new HashSet<>();
    	for (int i=0; i<Board.NB_LIN * Board.NB_COL; i++) {
    		set.add(new Piece());
    	}
    	return set;
    }

    @Override
    public void updatePlay(GameState state, Play action) {
        boolean end = false;
        Board board = state.getBoard();
        Player p = state.getCurrentPlayer();
        final char opponentChar = opponent(p).displayChar();
        if (board.getContent(action.getLine(), action.getColumn()) == opponentChar) {
            System.out.println("This cell is occupied by the opponent: "
                    + p.getName() + " wins!");
            state.setWinner(p);
            end = true;
        } else if (board.getContent(action.getLine(), action.getColumn()) == p.displayChar()) {
            System.out.println("This cell is occupied by the player: "
                    + opponent(p).getName() + " wins!");
            state.setWinner(opponent(p));
            end = true;
        } else {
            board.setContent(action.getLine(), action.getColumn(),
                    state.getCurrentPlayer().displayChar());
            int next = (state.getCurrentPlayerIndex() + 1) % 2;
            state.setCurrentPlayer(next);
        }
        state.setEnd(end);
    }
}
