package Examples.SnakeAndLadder;

import java.util.HashMap;

public class Board {
    int N; // N X N board
    HashMap<Integer, Snake> snakes;
    HashMap<Integer, Ladder> ladders;
    
    public Board(int N) {
        this.N = N;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public int getWinningPosition() {
        return this.N * this.N;
    }

    public void addSnake(int from, int to) {
        try {
            Snake s = new Snake(from, to);
            snakes.put(from, s);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addLadder(int from, int to) {
        try {
            Ladder l = new Ladder(from, to);
            ladders.put(from, l);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public HashMap<Integer, Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(HashMap<Integer, Snake> snakes) {
        this.snakes = snakes;
    }

    public HashMap<Integer, Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(HashMap<Integer, Ladder> ladders) {
        this.ladders = ladders;
    }
}
