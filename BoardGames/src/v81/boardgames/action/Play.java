package v81.boardgames.action;

import v81.boardgames.game.GameState;
import v81.boardgames.game.IGame;
import v81.boardgames.game.Coord.Coord;

/**
 * Action "Play".
 */
public class Play implements IAction {

    /**
     * Line chosen by the player.
     */
    private final int line;

    /**
     * Column chosen by the player.
     */
    private final int column;

    /**
     * Constructor.
     *
     * @param aLine line (if Play)
     * @param aColumn column (if Play)
     */
    public Play(final Coord someCoord) {
         coord = someCoord;
    }

    public Coord getCoord() {
        return coord;
    }



    @Override
    public void perform(IGame game, GameState state) {
        game.updatePlay(state, this);
        System.out.println("## Board updated. ##");
    }

    @Override
    public String toString() {
        return "(" + (char)('a' + line) + "," + (char)('A' + column) + ")";
    }
}
