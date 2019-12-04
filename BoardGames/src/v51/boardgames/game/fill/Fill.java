package v51.boardgames.game.fill;

import v4.boardgames.game.Action;
import v4.boardgames.game.Board;
import v4.boardgames.game.GameState;
import v4.boardgames.game.IGame;
import v4.boardgames.io.FileUtils;
import v51.boardgames.player.Player;

/**
 * A 2-player game where each one wants to fill the board.
 */
class Fill implements IGame{

    /**
     * Starts the game.
     */
    private void startGame() {
        GameState state = new GameState(new Board(), true);
        while (!state.isEnd()) {
            System.out.println(state.board.display(false));
            final Player action = Player.play();
            switch (action.type) {
                case QUIT:
                    state.setEnd(true);
                    System.out.println("## Bye. ##");
                    break;
                case PLAY:
                    state.updatePlay(action);
                    System.out.println("## Board updated. ##");
                    break;
                case LOAD:
                    state = FileUtils.load();
                    System.out.println("## Previous game loaded. ##");
                    break;
                case SAVE:
                    FileUtils.save(state);
                    System.out.println("## Game saved. ##");
                    break;
                default:
                    System.out.println("Not implemented : " + action.type);
                    break;
            }
        }
    }

    /**
     * Main method.
     *
     * @param args no arguments required so far.
     */
    public static void main(String[] args) {
        final Fill f = new Fill();
        f.startGame();
    }

	@Override
	public void updatePlay(GameState state, Action action) {
		state.updatePlay(action);
		
	}
}
