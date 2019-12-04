package v81.boardgames.player;

import java.util.Random;
import v81.boardgames.action.Play;
import v81.boardgames.game.Board;
import v81.boardgames.game.GameState;
import v81.boardgames.action.IAction;

/**
 * A stupid IA player, purely random.
 */
public class IAPlayer extends Player {

    /**
     * Constructor.
     * 
     * @param aName player's name
     */
    public IAPlayer(String aName) {
        super(aName);
    }

    @Override
    public IAction play(GameState g) {
        // pick a random line an column
        final Random r = new Random();
        final int line = r.nextInt(Board.NB_LIN);
        final int col = r.nextInt(Board.NB_COL);
        return new Play(line, col);
    }
}
