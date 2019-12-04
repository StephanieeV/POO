package v53.boardgames.game;

/**
 * State of the game, fully described.
 */
public class GameState {

    /**
     * Current board of the game.
     */
    private final Board board;

    /**
     * Is the current player the black player?
     */
    private boolean isBlack;
    
    public int current;

    /**
     * End of the game?
     */
    private boolean end;
    
    /**
     * The winner, once the game ended.
     */
    private char winner;
    
    /**
     * Constructor.
     *
     * @param aBoard current board
     * @param isItBlack current player (black?)
     */
    public GameState(final Board aBoard, final int c) {
        board = aBoard;
        current = c;
        end = false;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
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

    public void setWinner(char winner) {
        this.winner = winner;
    }

	
}
