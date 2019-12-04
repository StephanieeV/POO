package v61.boardgames.game.crush3;

import v61.boardgames.action.Play;
import v61.boardgames.game.Board;
import v61.boardgames.game.GameState;
import v61.boardgames.game.Game;
import v61.boardgames.game.Piece;
import v61.boardgames.player.HumanPlayer;
import v61.boardgames.player.IAPlayer;
import v61.boardgames.player.Player;

import java.util.HashSet;
import java.util.Set;
/**
 * Crush3 game.
 */
public class Crush3 extends Game  {

    /**
     * Constructor.
     */
    public Crush3() {
        super(2); // 2 players, with 3 pieces each
        players[0] = new IAPlayer("Black");
        players[1] = new HumanPlayer("White");
    }

    public Set<Piece> initPieces(Player p){
    	Set<Piece> set = new HashSet<>();
    	for (int i=0; i<3; i++) {
    		set.add(new Piece());
    	}
    	return set;
    }

    @Override
    public void updatePlay(GameState state, Play action) {
        
        // at the beginning, same rules as Crush
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
        state.takeAPiece(state.getCurrentPlayer());
        if (!end) {
            // check whether a player can still play
            boolean toBeContinued = false;
            int i = 0;
            for (Player pl : players) {
                toBeContinued |= (state.piecesOfPlayer(p).size() > 0);
            }
            // if no player can play, end
            if (!toBeContinued) {
                System.out.println("No piece to play: draw!");
                end = true;
            }
        }
        state.setEnd(end);
    }

}
