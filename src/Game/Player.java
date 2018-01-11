package Game;

/**
 * Representing a player in the game.
 */
public abstract class Player {

    private boolean had_move_;
    private cell player_id_;
    private String name_;
    /**
     * Constructor.
     */
    public Player(cell num_player) {
        this.had_move_ = false;
        this.player_id_ = num_player;
    }
    /**
     * Sets the name of the player for this game.
     * @param name string
     */
    public void setName(String name) {
        this.name_ = name;
    }
    /**
     * @return name of the player
     */
    public String getName() {
        return this.name_;
    }
    /**
     * Checks if the player had a move.
     * @return true if player had a move, false otherwise
     */
    public void hasMove(Boolean played) {
        this.had_move_ = played;
    }
    /**
     * Checks if the player had a move.
     * @return true if player had a move, false otherwise
     */
    public Boolean played() {
        return this.had_move_;
    }
    /**
     * @return number of the player, 1 or 2
     */
    public cell getId() {
        return this.player_id_;
    }
    abstract void message();
    abstract Coordinates getMove();
}