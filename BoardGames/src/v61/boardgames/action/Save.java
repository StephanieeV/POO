package v61.boardgames.action;

import v61.boardgames.game.GameState;
import v61.boardgames.game.IGame;
import v61.boardgames.io.FileUtils;

/**
 * Action "Save".
 */
public class Save implements IAction {

    @Override
    public void perform(IGame game, GameState state) {
        FileUtils.save(state);
        System.out.println("## Game saved. ##");
    }
    
    @Override
    public String toString() {
        return "Save";
    }
}
