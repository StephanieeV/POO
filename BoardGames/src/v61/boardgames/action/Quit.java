package v61.boardgames.action;

import v61.boardgames.game.GameState;
import v61.boardgames.game.IGame;

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
