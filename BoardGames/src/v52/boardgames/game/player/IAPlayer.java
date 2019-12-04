package v52.boardgames.game.player;

import java.util.Random;

import v4.boardgames.game.Board;
import v51.boardgames.game.Action;
import v51.boardgames.game.ActionType;


public class IAPlayer extends Player{
	public IAPlayer(String nm) {
		super(nm);
	}
	public Action play() {
		Random r = new Random();
		int line = r.nextInt(Board.NB_LIN);
		int col = r.nextInt(Board.NB_COL);
		return new Action(ActionType.PLAY, line, col);
		
	}

}
