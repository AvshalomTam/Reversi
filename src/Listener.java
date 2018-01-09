public interface Listener {
    /**
     * Sets the name of the previous player.
     * @param name string
     */
    void setPreName(String name);
    /**
     * @return name of previous player
     */
    String getName();
    /**
     * Sets the move of the previous player.
     * @param c Coordinates
     */
    void setPreMove(Coordinates c);
    /**
     * @return previous move
     */
    Coordinates getPreMove();
    /**
     * Sets boolean saying if previous player had a move.
     * @param had_move boolean
     */
    void hadMove(boolean had_move);
    /**
     * @return true if previous player had a move, false otherwise
     */
    boolean preHadMove();
}
