import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleDisplay implements Display {
    /**
     * Prints the current state of board.
     * @param board Board object
     */
    public void printCurrentBoard(Board board) {
        System.out.println("\nCurrent board:\n");
        board.printBoard();
        System.out.println();
    }
    /**
     * Prints the previous players move.
     * @param name of player
     * @param coordinate move
     */
    public void printPreviousMove(String name, String coordinate) {
        System.out.println(name +  " played " + coordinate + "\n");
    }
    /**
     * Prints whos turn it is.
     * @param name of player
     */
    public void printTurn(String name) {
        System.out.println(name + " it's your turn.");
    }
    /**
     * Prints a message that player has no move.
     */
    public void printNoMove() {
        System.out.println("No possible moves. Play passes to the other player. Press ENTER to continue.");
        try{
            System.in.read();
        } catch (Exception e) {}
    }
    /**
     * Prints the options for the player.
     * @param options list of coordinates
     */
    public void printOptions(ArrayList<Coordinates> options) {
        //printing the player's options
        System.out.print("Your possible moves: ");
        int i = 1;
        for(Coordinates c : options) {
            if (i == 1) {
                System.out.print(c.move(new Coordinates(1, 1)).toString());
                i++;
            }
            else {
                System.out.print(" , " + c.move(new Coordinates(1, 1)).toString());
            }
        }
        System.out.println();
    }
    /**
     * Asking player for a move.
     */
    public void printMoveRequest() {
        System.out.print("Please enter your move row,col: ");
    }
    /**
     * Printing an error message in case of wrong input.
     * @param error
     */
    public void printInputError(String error) {
        System.out.println("\n" + error + "\n");
    }
    /**
     * Prints the result of the game.
     * @param name of the winning player
     */
    public void printResult(String name) {
        System.out.println("\nG A M E   O V E R");
        if (name.equals("draw")) {
            System.out.println("DRAW GAME !!!!\n");
        }
        else {
            System.out.println(name + " wins the game.\n");
        }
    }
    /**
     * Gets an input from a (human) player and returns it as a String.
     * @return String
     */
    public String input() {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        return s;
    }
}
