package v53.boardgames.game.player;

import java.util.Random;

import v50.boardgames.game.*;

public class IAPlayer extends Player {
	
	public IAPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Action play() {
		Random r = new Random();
		int line = r.nextInt(Board.NB_LIN);
		int col = r.nextInt(Board.NB_COL);
		
		return new Action(ActionType.PLAY,line,col);
	}
}
