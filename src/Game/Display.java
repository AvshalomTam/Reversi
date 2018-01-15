package Game;

import java.util.ArrayList;

public interface Display {
    /**
     * Printing the board.
     */
    void printBoard();

    /**
     * Printing info about the game (player's score etc.).
     */
    void printGameInfo();

    /**
     * Showing the pplayer his options.
     * @param options list of the Coordinates
     */
    void showOptions(ArrayList<Coordinates> options);

    /**
     * Printing a message that the player has no move.
     */
    void printNoMove();

    /**
     * Printing the result of the game.
     * @param result String containing the result
     */
    void printGameResults(String result);

}
