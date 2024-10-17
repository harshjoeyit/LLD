package Examples.TicTacToe;

import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int _size) {
        this.size = _size;
        // create a board of size - size X size
        board = new PlayingPiece[size][size];
    }

    public boolean playAPiece(int row, int col, Player player) {
        // validations
        if (row < 0 || row >= this.size || col < 0 || col > this.size) {
            System.err.println("invalid location: cannot play the piece since out of bound");
            return false;
        }

        // check if a piece already exits on the location 
        if (this.board[row][col] != null) {
            System.err.println("invalid location: piece already exists");
            return false;
        }

        // assign the piece to given row, col
        board[row][col] = player.getPiece();

        return true;
    }

    public void displayBoard() {
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                
                char displayPiece = ' ';
                if (this.board[i][j] != null) {
                    displayPiece = this.board[i][j].getPieceChar();
                }

                System.out.print("\t" + displayPiece);

                // separator
                if (j < this.size - 1) {
                    System.out.print("\t" + "|");
                }
            }
            // change line for each row
            System.out.println();
        }
    }

    public Player getWinner(List<Player> players) {
        PlayingPiece winningPiece = this.isGameOver();
        
        if (winningPiece == null) {
            // game should continue as there is no winner
            return null;
        }

        for (Player player: players) {
            if (winningPiece.getPieceChar() == player.getPiece().getPieceChar()) {
                return player;
            }
        }        

        // code should never reach here, in case it does that means
        // the winning piece is assigned to none of the characters
        
        System.err.println("Winning piece " + winningPiece.getPieceChar() + " does not belong to any player");

        return null;
    }

    // returns PlayingPiece which wins the game if game is over, else null
    private PlayingPiece isGameOver() {        
        // check each row 
        for(int i = 0; i < this.size; i++) {
            int j;
            for(j = 1; j < this.size; j++) {
                if (
                    board[i][j] == null 
                    || board[i][j-1] == null
                    || (board[i][j].getPieceChar() != board[i][j-1].getPieceChar())
                ) {
                    break;
                }
            }
            
            if (j == this.size) {
                // return the winning piece;
                return this.board[i][0];
            }
        }

        // check each col
        for(int j = 0; j < this.size; j++) {
            int i;
            for(i = 1; i < this.size; i++) {
                if (
                    board[i][j] == null 
                    || board[i-1][j] == null
                    || (board[i][j].getPieceChar() != board[i-1][j].getPieceChar())
                ) {
                    break;
                }
            }

            if (i == this.size) {
                // return the winning piece;
                return this.board[0][j];
            }
        }

        // check top-left to bottom-right diagonal
        int i = 1;
        for(i = 1; i < this.size; i++) {
            if (
                this.board[i][i] == null
                || this.board[i-1][i-1] == null
                || (this.board[i][i].getPieceChar() != this.board[i-1][i-1].getPieceChar())
            ) {
                break;
            }
        }
        if (i == this.size) {
            return this.board[0][0];
        }

        // check top-right to bottom-left diagonal
        for(i = 1; i < this.size; i++) {
            int j = this.size - 1 - i;
            if (
                this.board[i][j] == null
                || this.board[i-1][j+1] == null
                || (this.board[i][j].getPieceChar() != this.board[i-1][j+1].getPieceChar())
            ) {
                break;
            }
        }
        if (i == this.size) {
            return this.board[0][this.size-1];
        }

        // game is not over yet
        return null;
    }
}
