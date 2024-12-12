package Examples.SnakeAndLadder;

import java.util.Random;

public class Dice {
    private final int low;
    private final int high;
    Random rand;

    public Dice() {
        this.low = 1;
        this.high = 6;
        rand = new Random();
    }

    public int rollDice() {
		return low + rand.nextInt(high);
    }
}
