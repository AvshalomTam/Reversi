package Game;

import java.util.ArrayList;

public interface GameLogic {
    /**
     * Checks if num+player has any moves.
     * @param board Board object
     * @param num_player player's number
     * @return true if he has any move, false otherwise
     */
    boolean hasOptions(Board board, cell num_player);
    /**
     * Creates a list of all the options the player has according to the player's number.
     * @param num_player player's number
     * @return list of coordinates
     */
    ArrayList<Coordinates> getOptions(Board board, cell num_player);
    /**
     * Check if the choice c num_player has chosen, is valid.
     * @param board game board
     * @param c coordinates
     * @param num_player number of player
     * @return true if valid, false otherwise
     */
    boolean isValidChoice(Board board, Coordinates c, cell num_player) throws Exception;
    /**
     * Turns the tiles according the rules after placing num_player on c.
     * @param c coordinates
     * @param num_player the player who wants to turn some tiles
     */
    void turnTiles(Board board, Coordinates c, cell num_player);
    /**
     * Checks who's the winner of the game.
     * @return number of player who won and 0 for a draw
     */
    cell checkWinner(Board board);
    /**
     * @return true if the board is full, false otherwise
     */
    boolean boardIsFull(Board board);
    int getScore(Board board, cell player);
}
