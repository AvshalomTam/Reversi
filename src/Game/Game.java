package Game;

public class Game {
    private Display display_;
    private Board board_; // pointer, so it can point to inherited
    private Player pl1_; // pointer, so it can point to inherited
    private Player pl2_; // pointer, so it can point to inherited
    private GameLogic judge_; // pointer, so it can point to inherited
    private boolean frst_player_; // boolean telling who's turn it is
    private Listener listen_;
    private static final Coordinates NO_MOVE = new Coordinates(-1, -1);

    /**
     * Constructor.
     */
    public Game() {
        this.frst_player_ = true;
    }
    /**
     * Initializes the board, the players etc.
     */
    public void initialize(Board board, Display display) {
        this.board_ = board;
        this.display_ = display;
        this.judge_ = new BasicRules();
        this.listen_ = new MoveTracker();
        this.pl1_ = new HumanPlayer(cell.first_player, this.board_, this.judge_, this.display_, this.listen_);
        this.pl2_ = new HumanPlayer(cell.second_player, this.board_, this.judge_, this.display_, this.listen_);
        this.pl1_.setName("X");
        this.pl2_.setName("O");
    }
    /**
     * Runs the game.
     */
    public void run() {
        do {
            if (this.frst_player_) {
                this.playOneTurn(this.pl1_);
            } else {
                this.playOneTurn(this.pl2_);
            }
            this.frst_player_ = !this.frst_player_;
        } while ((this.pl1_.played() || this.pl2_.played()) && !this.judge_.boardIsFull(this.board_));

        this.board_.printBoard();
        //printing the game results
        cell winner = this.judge_.checkWinner(this.board_);
        if (winner == cell.empty) {
            this.display_.printResult("draw");
        }
        else {
            if (winner == cell.first_player) {
                this.display_.printResult(this.pl1_.getName());
            }
            else {
                this.display_.printResult(this.pl2_.getName());
            }
        }
    }
    /**
     * Player plays a turn.
     * @param pl reference to player
     */
    public void playOneTurn(Player pl) {
        this.display_.printCurrentBoard(this.board_);

        pl.message();

        Coordinates input = pl.getMove();
        if (!NO_MOVE.isEqual(input)) {
            this.judge_.turnTiles(this.board_, input, pl.getId());
        }
    }
}
