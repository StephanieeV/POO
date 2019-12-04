package v51.boardgames.player;

import java.util.Scanner;

public abstract class IAPlayer extends Player{
	
	static final Scanner SCAN = new Scanner(System.in);
	
	public IAPlayer() {
		
	}
	public play() {
		boolean black = true;
		System.out.println((balck ? "Black" : "White") + " plays...");
        System.out.println("Your action : ");
        final String action = SCAN.next();
        return fromKeyboard(action);
	}
}
