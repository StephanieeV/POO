package v53.boardgames.game.player;

import v53.boardgames.game.*;

public abstract class Player {
	String name;
	
	Player(String name){
		this.name = name;
	}
	
	public Action play() {
		return null;
		
	}
}
