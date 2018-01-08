import java.util.ArrayList;

public class BasicRules implements GameLogic {
    /**
     * Checks if num+player has any moves.
     * @param board Board object
     * @param num_player player's number
     * @return true if he has any move, false otherwise
     */
    public boolean hasOptions(Board board, cell num_player) {
        return !this.getOptions(board, num_player).isEmpty();
    }
    /**
     * Creates a list of all the options the player has according to the player's number.
     * @param num_player player's number
     * @return list of coordinates
     */
    public ArrayList<Coordinates> getOptions(Board board, cell num_player) {
        //iterating over the whole board in order to check every cell
        ArrayList <Coordinates> options = new ArrayList<Coordinates>();
        cell current_cell;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                current_cell = board.getCell(new Coordinates(i, j));
                if (current_cell == cell.empty) {
                    if (isValidOption(board, new Coordinates(i, j), num_player)) {
                        options.add(new Coordinates(i, j));
                    }
                }
            }
        }
        return options;
    }

    private boolean isValidOption(Board board, Coordinates c, cell num_player) {
        //array containing all the 8 directions
        Coordinates[] vector = {new Coordinates(0, -1), new Coordinates(0, 1), new Coordinates(1, -1), new Coordinates(1, 0),
                new Coordinates(1, 1), new Coordinates(-1, -1), new Coordinates(-1, 0), new Coordinates(-1, 1)};
        for (int i = 0; i < 8; i++) {
            if (isValidPath(board, c, num_player, vector[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidPath(Board board, Coordinates c, cell num_player, Coordinates vector) {
        boolean other_sign = false;
        Coordinates tmp = c.move(vector);
        while ((tmp.getX() < board.getSize() && (tmp.getX() >= 0)
                && (tmp.getY() < board.getSize()) && tmp.getY() >= 0)) {
            if (board.getCell(tmp) == num_player) {
                return other_sign;
            }
            else {
                if (board.getCell(tmp) == cell.empty) {
                    return false;
                }
                other_sign = true;
                tmp = tmp.move(vector);
            }
        }
        return false;
    }

    /**
     * Check if the choice c num_player has chosen, is valid.
     * @param board game board
     * @param c coordinates
     * @param num_player number of player
     * @return true if valid, false otherwise
     */
    public boolean isValidChoice(Board board, Coordinates c, cell num_player) throws Exception {
        if (c.getX() < 0 || c.getX() >= board.getSize() || c.getY() < 0 || c.getY() >= board.getSize()) {
            throw new Exception("Out of the game borders!");
        }
        return board.getCell(c) == cell.empty && isValidOption(board, c, num_player);

    }

    /**
     * Turns the tiles according the rules after placing num_player on c.
     * @param c coordinates
     * @param num_player the player who wants to turn some tiles
     */
    public void turnTiles(Board board, Coordinates c, cell num_player) {
        if (!isValidOption(board, c, num_player)) {
            return;
        }

        board.setCell(c, num_player);
        Coordinates[] vector = {new Coordinates(0, -1), new Coordinates(0, 1), new Coordinates(1, -1), new Coordinates(1, 0),
                new Coordinates(1, 1), new Coordinates(-1, -1), new Coordinates(-1, 0), new Coordinates(-1, 1)};
        for (int i = 0; i < 8; i++) {
            if (isValidPath(board, c, num_player, vector[i])) {
                Coordinates tmp = c.move(vector[i]);
                while (board.getCell(tmp) != num_player) {
                    board.setCell(tmp, num_player);
                    tmp = tmp.move(vector[i]);
                }
            }
        }
    }

    /**
     * Checks who's the winner of the game.
     * @return number of player who won and 0 for a draw
     */
    public cell checkWinner(Board board) {
        int difference = board.getScore(cell.first_player) - board.getScore(cell.second_player);
        if (difference == 0) {
            return cell.empty;
        }
        if (difference > 0) {
            return cell.first_player;
        }
        return cell.second_player;

    }
    /**
     * @return true if the board is full, false otherwise
     */
    public boolean boardIsFull(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(new Coordinates(i, j)) == cell.empty) {
                    return false;
                }
            }
        }
        return true;
    }
}
