package v51.boardgames.player;

import java.util.Scanner;

public abstract class HumanPlayer extends Player {
	
	static final Scanner SCAN = new Scanner(System.in);
	
	public HumanPlayer() {
		
	}
	
	public play(boolean black) {
		System.out.println((black ? "Black" : "White") + " plays...");
        System.out.println("Your action : ");
        final String action = SCAN.next();
        return fromKeyboard(action);
	}
}
