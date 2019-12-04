package v30.game.fill;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * An action of a player, in the Fill game.
 */
class Action {

    public class ActionType {

	}

	/**
     * Line chosen by the player.
     */
    static int line;

    /**
     * Column chosen by the player.
     */
    static int column;

    /**
     * Player wants to quit.
     */
    ActionType type;

    /**
     * Scanner used to read the input from keyboard.
     */
    static final Scanner s = new Scanner(System.in);

    /**
     * Constructor.
     */
    Action(ActionType t, int ln, int col) {
        type = t;
        line = ln;
        column = col;
    }

    /**
     * Ask the player for its next action, and record it.
     *
     * @param black is it the black player?
     */
    static Action getFromPlayer(boolean black, Board board) {
        System.out.println((black ? "Black" : "White") + " plays...");
        System.out.println("Your action : ");
        String action = s.next();
        return fromKeyboard(action, board);
    }

    /**
     * Record an action from the player.
     *
     * @param action String obtained from the player
     */
    static Action fromKeyboard(String action, Board board) {
        if (action == null || action.isEmpty()) {
            // empty action -> quit
            
            return new Action(ActionType.QUIT, -1, -1);
        }
        char firstChar = action.charAt(0);
        if (firstChar == 'q' || firstChar == 'Q') {
            // action : quit
            
            return new Action(ActionType.QUIT, -1, -1);
        }
        // action : save
        if (firstChar == 's' || firstChar == 'S') {
        	FileWriter fichier = new FileWriter("C:\\Users\\Stéphanie V\\Documents\\fichier.txt");
        	PrintWriter writer = new PrintWriter(fichier ,true);
        	writer.println(board);
        	writer.close();
        }
        // action : load
        if (firstChar == 'l' || firstChar == 'L') {
        	
        }
        // action : play
        char lineChar = firstChar;
        if ('a' <= lineChar && lineChar <= 'a' + board.NB_LIN - 1) {
            // line is valid
            if (action.length() == 1) {
                // no column -> quit
                System.out.println("No column: abort.");
                return new Action(ActionType.QUIT, -1, -1);
            } else {
                char colChar = action.charAt(1);
                if ('A' <= colChar && colChar <= 'A' + board.NB_COL - 1) {
                    // column is valid
                    line = lineChar - 'a';
                    column = colChar - 'A';
                } else {
                    // column is wrong
                    System.out.println("Wrong column: " + colChar);
                    return new Action(ActionType.QUIT, -1, -1);
                }
            }
        } else {
            // line is wrong
            System.out.println("Wrong line: " + lineChar);
            return new Action(ActionType.QUIT, -1, -1);
        }
		return new Action(ActionType.QUIT, -1, -1);
    }
    
    	
    	
    	
    }
}
