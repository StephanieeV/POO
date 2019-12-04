package v52.boardgames.game;

import v52.boardgames.game.player.Player;

public interface IGame {
	
	Player[] players();
	
	public void updatePlay(GameState state, Action action);
}
