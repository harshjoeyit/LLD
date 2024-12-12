package Examples.SnakeAndLadder;

public abstract class Jump {
    protected final int from;
    protected final int to;

    public Jump(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

	public int getTo() {
        return to;
    }

	protected abstract void validate() throws Exception;
}
