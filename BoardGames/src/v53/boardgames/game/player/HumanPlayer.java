package v53.boardgames.game.player;

import v53.boardgames.game.Action;
import java.util.Scanner;


public class HumanPlayer extends Player {
	
	public HumanPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action play() {
		return Action.getFromPlayer(name);
	}

}
