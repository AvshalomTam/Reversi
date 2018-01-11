package Game;

import java.util.ArrayList;

public interface Display {
    /**
     * Prints the current state of board.
     * @param board Board object
     */
    void printCurrentBoard(Board board);
    /**
     * Prints the previous players move.
     * @param name of player
     * @param coordinate move
     */
    void printPreviousMove(String name, String coordinate);
    /**
     * Prints whos turn it is.
     * @param name of player
     */
    void printTurn(String name);
    /**
     * Prints a message that player has no move.
     */
    void printNoMove();
    /**
     * Prints the options for the player.
     * @param options list of coordinates
     */
    void printOptions(ArrayList<Coordinates> options);
    /**
     * Asking player for a move.
     */
    void printMoveRequest();
    /**
     * Printing an error message in case of wrong input.
     * @param error
     */
    void printInputError(String error);
    /**
     * Prints the result of the game.
     * @param name of the winning player
     */
    void printResult(String name);
    /**
     * Gets an input from a (human) player and returns it as a String.
     * @return String
     */
    String input();
}
