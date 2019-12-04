package v51.boardgames.game.crush;

import v4.boardgames.game.Action;
import v4.boardgames.game.Board;
import v4.boardgames.game.GameState;
import v4.boardgames.game.IGame;
import v4.boardgames.io.FileUtils;

/**
 * A 2-player game where each one wants to fill the board.
 */
class Crush implements IGame{

    /**
     * Starts the game.
     */
    private void startGame() {
        GameState state = new GameState(new Board(), true);
        while (!state.isEnd()) {
            System.out.println(state.board.display(false));
            final Action action = Action.getFromPlayer(state.isBlack);
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
        final Crush f = new Crush();
        f.startGame();
    }

	@Override
	public void updatePlay(GameState state, Action action) {
		Board board = state.board;
		if (board.content[action.line][action.column] != ' ') {
            System.out.println("This cell is occupied: "
                    + (state.isBlack ? "White" : "Black") + " wins!");
            state.end = true;
            state.winner = (state.isBlack ? 'W' : 'B');
        } else {
            board.content[action.line][action.column] = (state.isBlack ? 'B' : 'W');
            state.isBlack = !state.isBlack;
        }
		
	}
}
