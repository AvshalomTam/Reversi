package Game;

public abstract class Player {
    private cell num_player;
    private String name;

    public Player(cell numPlayer, String name) {
        this.num_player = numPlayer;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public cell getNumPLayer() {
        return this.num_player;
    }
}
