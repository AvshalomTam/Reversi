package ReversiApp;

import Game.BasicRules;
import Game.Board;
import Game.GameLogic;
import Game.cell;

public class GameStatus {
    private cell current;
    private Board board;
    private GameLogic judge;
    private String pl1_name;
    private String pl2_name;

    public GameStatus(Board board, String p1, String p2, cell current ) {
        this.board = board;
        this.judge = new BasicRules();
        this.pl1_name = p1;
        this.pl2_name = p2;
        this.current = current;
    }

    public void changePlayers() {
        if (this.current == cell.first_player) {
            this.current = cell.second_player;
        } else {
            this.current = cell.first_player;
        }
    }

    public cell getCurrent() {
        return this.current;
    }

    public String getPl1Name() {
        return this.pl1_name;
    }

    public String getPl2Name() {
        return this.pl2_name;
    }

    public String getCurrentName() {
        if (this.current == cell.first_player) {
            return getPl1Name();
        }
        return getPl2Name();
    }

    public int getScore(cell player) {
        return this.judge.getScore(this.board, player);
    }
}
