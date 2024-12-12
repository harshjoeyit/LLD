package Examples.SnakeAndLadder;

public class Ladder extends Jump {

    public Ladder(int from, int to) throws Exception {
        super(from, to);
        validate();
    }

    protected void validate() throws Exception {
        if (from >= to) {
            throw new Exception("from < to");
        }
    };
}
