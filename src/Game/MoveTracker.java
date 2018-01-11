package Game;

public class MoveTracker implements Listener {
    private Coordinates previous_move_;
    private String pre_name_;
    private boolean pre_had_move_;

    public MoveTracker() {
        this.pre_had_move_ = false;
    }

    public void setPreName(String name) {
        this.pre_name_ = name;
    }

    public String getName() {
        return this.pre_name_;
    }

    public void setPreMove(Coordinates c) {
        this.previous_move_ = c;
    }

    public Coordinates getPreMove() {
        return this.previous_move_;
    }

    public void hadMove(boolean had_move) {
        this.pre_had_move_ = had_move;
    }

    public boolean preHadMove() {
        return this.pre_had_move_;
    }
}
