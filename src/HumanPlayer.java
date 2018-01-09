import java.util.ArrayList;

/**
 * Representing a human player.
 */
public class HumanPlayer extends Player {
    //members
    private Board board_;
    private GameLogic judge_;
    private Display gameflow_;
    private Listener listener_;
    /**
     * Constructor.
     *
     * @param numplayer first_player or second_player
     * @param board     Board object
     * @param judge     Gamelogic object
     * @param gameflow  Display object
     */
    public HumanPlayer(cell numplayer, Board board, GameLogic judge, Display gameflow, Listener listener) {
        super(numplayer);
        this.board_ = board;
        this.judge_ = judge;
        this.gameflow_ = gameflow;
        this.listener_ = listener;
    }

    /**
     * Gets coordinates in board where the player wants to put his tile
     *
     * @return coordinates
     */
    public Coordinates getMove() throws Exception {
        Coordinates c = new Coordinates(-1, -1);
        try {
            if (!this.judge_.hasOptions(this.board_, this.getId())) {
                this.listener_.hadMove(false);
                this.listener_.setPreMove(c);
                this.listener_.setPreName(this.getName());
                this.hasMove(false);

                return c;
            }
        } catch (Exception e) {
            throw e;
        }

        Coordinates input;
        this.hasMove(true);

        while (true) {
            try {
                String s = this.gameflow_.input();
                input = (new Coordinates(s)).move(new Coordinates(-1, -1));
                //checking if player's choice is one of the options
                if (this.judge_.isValidChoice(this.board_, input, this.getId())) {
                    break;
                } else {
                    throw new Exception("That's none of your choices!");
                }
            } catch (Exception error) {
                this.gameflow_.printInputError(error.getMessage());
                this.gameflow_.printMoveRequest();
                continue;
            }
        }
        try {
            this.listener_.hadMove(true);
            this.listener_.setPreMove(input);
            this.listener_.setPreName(this.getName());
            this.hasMove(true);
            return input;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Prints an appropiate message.
     */
    public void message() {
        //prints previous player move
        if (this.listener_.preHadMove()){
            this.gameflow_.printPreviousMove(this.listener_.getName(), (this.
            listener_.getPreMove().move(new Coordinates(1, 1)).toString()));
        }

        //prints whose turn it is
        this.gameflow_.printTurn(this.getName());

        if (!this.judge_.hasOptions(this.board_, this.getId())){
            this.gameflow_.printNoMove();
            return;
        }
        ArrayList<Coordinates> options = this.judge_.getOptions(this.board_, this.getId());
        //printing the player's options
        this.gameflow_.printOptions(options);

        this.gameflow_.printMoveRequest();

    }
}