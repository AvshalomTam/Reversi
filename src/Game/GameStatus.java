package Game;

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

    public GameStatus() {}

    public void setInfo(Board board, GameLogic judge, String p1_name, String p2_name, cell starter) {
        this.board = board;
        this.judge = judge;
        this.pl1_name = p1_name;
        this.pl2_name = p2_name;
        this.current = starter;
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
