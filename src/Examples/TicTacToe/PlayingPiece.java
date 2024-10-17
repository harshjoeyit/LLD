package Examples.TicTacToe;

// Base class for playing piece
public class PlayingPiece {
    char piece;

    public PlayingPiece(char _piece) {
        this.piece = _piece;
    }

    public char getPieceChar() {
        return this.piece;
    }
}

// children classes extending the base class 

class PlayingPieceX extends PlayingPiece {
    public PlayingPieceX() {
        super('X');
    }
}

class PlayingPieceO extends PlayingPiece {
    public PlayingPieceO() {
        super('O');
    }
}