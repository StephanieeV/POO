package v30.game.fill;

import v30.game.fill.Action.ActionType;

/**
 * A 2-player game where each one wants to fill the board.
 */
class Fill {

    /**
     * Starts the game.
     */
    void startGame() {
        final Board board = new Board();
        boolean end = false;
        boolean black = true;
        while (!end) {
            System.out.println(board.display(true));
            Action action =  Action.getFromPlayer(black, board);
            if (action.type = ActionType.QUIT) {
                end = true;
            } else {
                end = update(board, action, black);
                black = !black;
            }
        }
    }

    /**
     * Update the board according to the action of a player.
     *
     * @param 
     * @param action the action played
     * @param black is it the black player?
     * @return true if this is the end of the game
     */
    boolean update(Board board, Action action, boolean black) {
        boolean end = false;
        if (board.content[action.line][action.column] != ' ') {
            System.out.println("This cell is occupied: "
                    + (black ? "White" : "Black") + " wins!");
            end = true;
        } else {
            board.content[action.line][action.column] = (black ? 'B' : 'W');
        }
        return end;
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
}
