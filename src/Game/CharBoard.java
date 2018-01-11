package Game;

public class CharBoard extends Board {
    public CharBoard() {
        super(8);
    }

    public CharBoard(int size) {
        super(size);
    }

    public void printBoard() {
        int size = this.getSize();
        for (int i = 1; i <= size; i++) {
            System.out.print(" | " + i);
        }
        System.out.println(" |");
        for (int i = 0; i < 2 + 4 * size; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(" ");
                cell c = this.getCell(new Coordinates(i, j));
                if (c == cell.empty) {
                    System.out.print(" ");
                }
                if (c == cell.first_player) {
                    System.out.print("X");
                }
                if (c == cell.second_player) {
                    System.out.print("O");
                }
                System.out.print(" |");
            }
            System.out.println();
            for (int k = 0; k < 2 + 4 * size; k++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
