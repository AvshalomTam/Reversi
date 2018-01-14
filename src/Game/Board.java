package Game;

import java.util.ArrayList;

public abstract class Board {
    private cell[][] cells_;
    private int size_;

    public Board() {}

    public Board(int size) {
        this.size_ = size;
        this.cells_ = new cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells_[i][j] = cell.empty;
            }
        }
        this.cells_[size / 2 - 1][size / 2 - 1] = cell.second_player;
        this.cells_[size / 2][size / 2] = cell.second_player;
        this.cells_[size / 2 - 1][size / 2] = cell.first_player;
        this.cells_[size / 2][size / 2 - 1] = cell.first_player;
    }

    public int getSize() {
        return this.size_;
    }

    public cell getCell(Coordinates c) {
        return this.cells_[c.getX()][c.getY()];
    }

    public void setCell(Coordinates c, cell num_player) {
        this.cells_[c.getX()][c.getY()] = num_player;
    }

    public int getScore(cell num_player) {
        int score = 0;
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (this.cells_[i][j] == num_player) {
                    score++;
                }
            }
        }
        return score;
    }

    public abstract void printBoard();

    public abstract void showOptions(ArrayList<Coordinates> options);
}