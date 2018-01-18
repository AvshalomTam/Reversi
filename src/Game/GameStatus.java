package Game;

public class GameStatus {
    private cell current;
    private Board board;
    private GameLogic judge;
    private Player p1;
    private Player p2;
    private String pl1_name;
    private String pl2_name;
    private boolean finished;

    public GameStatus() {}

    public void setStarter(cell starter) {
        this.current = starter;
    }

    /**
     * Sets the info about status of game.
     * @param board game board
     * @param judge rules of the game
     * @param p1 color of the first player
     * @param p2 color of the second player
     * @param starter player starting the game
     */
    public void setInfo(Board board, GameLogic judge, Player p1, Player p2, cell starter) {
        this.board = board;
        this.judge = judge;
        this.p1 = p1;
        this.p2 = p2;
        this.current = starter;
        this.finished = false;
    }

    public void changePlayers() {
        if (this.current == cell.first_player) {
            this.current = cell.second_player;
        } else {
            this.current = cell.first_player;
        }
    }

    public Player getCurrent() {
        if (this.current == cell.first_player) {
            return this.p1;
        } else {
            return this.p2;
        }
    }

    public Player getP1() {
        return this.p1;
    }

    public Player getP2() {
        return this.p2;
    }

    /*public String getCurrentName() {
        if (this.current == cell.first_player) {
            return getPl1Name();
        }
        return getPl2Name();
    }*/

    public int getScore(cell player) {
        return this.judge.getScore(this.board, player);
    }

    public void setFinished() {
        this.finished = true;
    }

    public boolean isFinished() {
        return this.finished;
    }
}
