package v52.boardgames.game.player;

import v52.boardgames.game.*;

public abstract class HumanPlayer extends Player {
	public HumanPlayer(String nm) {
		super(nm);
	}
	public Action play() {
		return Action.getFromPlayer(name);
	}

}
