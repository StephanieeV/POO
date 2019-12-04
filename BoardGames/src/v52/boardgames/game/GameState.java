package v52.boardgames.game;

/**
 * State of the game, fully described.
 */
public class GameState {

    /**
     * Current board of the game.
     */
    public final Board board;

    /**
     * Is the current player the black player?
     */
    public int isBlack;
    
    public int current;

    /**
     * End of the game?
     */
    public boolean end;

    /**
     * The winner, once the game ended.
     */
    public char winner;

    /**
     * Constructor.
     *
     * @param aBoard current board
     * @param isItBlack current player (black?)
     */
    public GameState(final Board aBoard, final int c) {
        board = aBoard;
        isBlack = c;
    }

    /**
     * Update the board according to the action "Play" of a player.
     *
     * @param action the action played
     * @param black is it the black player?
     */
    public void updatePlay(final Action action) {
        if (board.content[action.line][action.column] != ' ') {
            System.out.println("This cell is occupied: "
                    + (isBlack ? "White" : "Black") + " wins!");
            end = true;
            winner = (isBlack ? 'W' : 'B');
        } else {
            board.content[action.line][action.column] = (isBlack ? 'B' : 'W');
            isBlack = !isBlack;
        }
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public char getWinner() {
        return winner;
    }
}
