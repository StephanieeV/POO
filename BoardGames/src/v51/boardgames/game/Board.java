package v51.boardgames.game;

/**
 * Board of the Fill game.
 */
public class Board {

    /**
     * Number of lines of the board.
     */
    public static final int NB_LIN = 4;

    /**
     * Number of columns of the board.
     */
    public static final int NB_COL = 4;

    /**
     * Content of an empty cell.
     */
    public static final char EMPTY_CELL = ' ';

    /**
     * Content of the board.
     */
    public final char content[][];

    /**
     * Constructor.
     */
    public Board() {
        content = new char[NB_LIN][NB_COL];
        for (int lin = 0; lin < NB_LIN; lin++) {
            for (int col = 0; col < NB_COL; col++) {
                content[lin][col] = EMPTY_CELL;
            }
        }
    }

    /**
     * Display this board.
     *
     * @return a String representing this board.
     */
    public String display(boolean separators) {
        final StringBuilder sb = new StringBuilder();
        // first line : name of columns
        sb.append("   ");
        for (int col = 0; col < NB_COL; col++) {
            sb.append((char) ('A' + col));
            sb.append(" ");
        }
        sb.append(System.lineSeparator());
        // following lines
        for (int lin = 0; lin < NB_LIN; lin++) {
            sb.append(separators ? separatorsLine() : "");
            sb.append((char) ('a' + lin));
            sb.append(" ");
            for (int col = 0; col < NB_COL; col++) {
                sb.append(separators ? "|" : " ");
                sb.append(content[lin][col]);
            }
            sb.append(separators ? "|" : "");
            sb.append(System.lineSeparator());
        }
        sb.append(separators ? separatorsLine() : "");
        return sb.toString();
    }

    /**
     * A horizontal line of separator characters.
     *
     * @return the line
     */
    StringBuilder separatorsLine() {
        final StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int col = 0; col < NB_COL; col++) {
            sb.append("+-");
        }
        sb.append("+");
        sb.append(System.lineSeparator());
        return sb;
    }
}
