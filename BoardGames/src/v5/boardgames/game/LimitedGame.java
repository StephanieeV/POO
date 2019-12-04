package v5.boardgames.game;

import v5.boardgames.player.Player;

/**
 * Abstract class for a game.
 */
public abstract class LimitedGame implements Game {
    int initNbPieces;

    /**
     * Constructor.
     *
     * @param nbPlayers number of players
     */
    public LimitedGame(int nbPlayers, int n) {
      super(nbPlayers);
      int nbPieces = 3;
    }

    public GameState initialState() {
        return new LimitedGameState(new Board(), 0, this, initNbPieces);
    }

}
