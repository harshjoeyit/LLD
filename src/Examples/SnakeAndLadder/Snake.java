package Examples.SnakeAndLadder;

public class Snake extends Jump {

    public Snake(int from, int to) throws Exception {
        super(from, to);
        validate();
    }

    protected void validate() throws Exception {
        if (from <= to) {
            throw new Exception("from > to");
        }
    };
}
