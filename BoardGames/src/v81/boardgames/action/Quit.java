package v81.boardgames.action;

import v81.boardgames.game.GameState;
import v81.boardgames.game.IGame;

/**
 * Action "Quit".
 */
public class Quit implements IAction {

    @Override
    public void perform(IGame game, GameState state) {
        state.setEnd(true);
        System.out.println("## Bye. ##");
    }
    
    @Override
    public String toString() {
        return "Quit";
    }
}
