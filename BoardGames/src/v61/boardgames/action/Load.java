package v61.boardgames.action;

import v61.boardgames.game.GameState;
import v61.boardgames.game.IGame;
import v61.boardgames.io.FileUtils;

/**
 * Action "Load".
 */
public class Load implements IAction {

    @Override
    public void perform(IGame game, GameState state) {
        FileUtils.load(game, state);
        System.out.println("## Previous game loaded. ##");
    }
    
    @Override
    public String toString() {
        return "Load";
    }
}
