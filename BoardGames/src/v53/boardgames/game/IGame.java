package v53.boardgames.game;

import v53.boardgames.game.player.Player;

/**
 * Interface of a game.
 */
public interface IGame {

	

	Player[] players();
    
    /**
     * Updates the state of the game, according to an action.
     * 
     * @param state current state of the game
     * @param action action played
     */
    void updatePlay(GameState state, Action action);
}
