package Game;

public class Coordinates {
    private int x_;
    private int y_;

    public Coordinates() {
        this.x_ = 0;
        this.y_ = 0;
    }

    public Coordinates(int x, int y) {
        this.x_ = x;
        this.y_ = y;
    }

    public Coordinates(String c) throws Exception{
        char[] s = c.toCharArray();
        int i = 0;
        this.x_ = 0;
        while (s[i] != ',') {
            if (s[i] < '0' || s[i] > '9') {
                throw new Exception("Wrong parameters!");
            }
            this.x_ = 10 * this.x_ + s[i] - '0';
            i++;
        }
        i++;
        this.y_ = 0;
        while(i < s.length) {
            if (s[i] < '0' || s[i] > '9') {
                throw new Exception("Wrong parameters!");
            }
            this.y_ = 10 * this.y_ + s[i] - '0';
            i++;
        }
    }

    public void setX(int x) {
        this.x_ = x;
    }

    public void setY(int y) {
        this.y_ = y;
    }


    public int getX() {
        return this.x_;
    }

    public int getY() {
        return this.y_;
    }

    public String toString() {
        return "(" + intToString(this.x_) + "," + intToString(this.y_ ) + ")";
    }

    public Coordinates move(Coordinates vector) {
        return new Coordinates(this.x_ + vector.getX(), this.y_ + vector.getY());
    }

    String intToString(int num) {
        Integer s = num;
        return s.toString();
    }

    public boolean isEqual(Coordinates other) {
        return this.getX() == other.getX() && this.getY() == other.getY();
    }
}
