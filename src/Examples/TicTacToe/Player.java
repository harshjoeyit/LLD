package Examples.TicTacToe;

public class Player {
    String name;
    PlayingPiece piece;

    public Player(String _name, PlayingPiece piece) {
        this.name = _name;
        this.piece = piece;
    }

    // getter method for name
    public String getName() {
        return this.name;
    }

    // getter method for piece
    public PlayingPiece getPiece() {
        return this.piece;
    }
}
