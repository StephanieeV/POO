package v5.boardgames.game.crush3;

import v5.boardgames.game.Action;
import v5.boardgames.game.Board;
import v5.boardgames.game.LimitedGame;
import v5.boardgames.game.LimitedGameState;
import v5.boardgames.player.HumanPlayer;
import v5.boardgames.player.IAPlayer;
import v5.boardgames.player.Player;

/**
 * Crush game: place a piece on the same cell as your opponent.
 */
public class Crush3 extends LimitedGame {

    /**
     * Constructor.
     */
    public Crush3() {
        super(2,3);
        players[0] = new IAPlayer("Black");
        players[1] = new HumanPlayer("White");
    }

    @Override
    public void updatePlay(GameState state, Action action) {
      LimitedGameState lstate = (LimitedGameState) state;
        Board board = state.getBoard();
        Player p = state.getCurrentPlayer();
        final char opponentChar = opponent(p).displayChar();
        if (board.getContent(action.getLine(), action.getColumn()) == opponentChar) {
            System.out.println("This cell is occupied by the opponent: "
                    + p.getName() + " wins!");
            state.setWinner(p);
            state.setEnd(true);
        } else if (board.getContent(action.getLine(), action.getColumn()) == p.displayChar()) {
            System.out.println("This cell is occupied by the player: "
                    + opponent(p).getName() + " wins!");
            state.setWinner(opponent(p));
            state.setEnd(true);
        } else {
            board.setContent(action.getLine(), action.getColumn(),
                    state.getCurrentPlayer().displayChar());
            lstate.decreaseOnePiece(state.getCurrentPlayerIndex);

            int next = (state.getCurrentPlayerIndex() + 1) % 2;
            state.setCurrentPlayer(next);
            int nbPieces = 0;
            for (int i=0; i<lstate.getnbPieces().lenght; i++){
              nbPieces += lstate.getNbPieces()[i];
            }
            if (nbPieces==0){
              System.out.println("Draw: no piece to play");
              state.setEnd(true);
            }
        }

    }
}
