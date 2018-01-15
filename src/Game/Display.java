package Game;

import java.util.ArrayList;

public interface Display {
    void printBoard();

    void printGameInfo();

    void showOptions(ArrayList<Coordinates> options);

    void printNoMove();

    void printGameResults(String result);

}
