package Examples.TicTacToe;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    List<Player> players;
    Board playingBoard;

    // holds index of the player with next move,
    // index moves to next player after each move,
    // after last player, it reaches the first again
    int playerWithNextMove;
    int totalMovesTillNow;

    Scanner scanner;

    GameManager() {
        initGame();
        this.scanner = new Scanner(System.in);
    }

    private void initGame() {
        // get input for how many players want to play the game
        // get input on size of the board

        // initializing the board
        this.playingBoard = new Board(3);

        // initializing players
        Player player1 = new Player("P1", new PlayingPiece('X'));
        Player player2 = new Player("P2", new PlayingPiece('O'));

        this.players = new ArrayList<Player>();
        
        // adding players to the list
        this.players.add(player1);
        this.players.add(player2);

        // input who makes the first move or assign randomly
        // default: player at index 0 in the list makes first move
        this.playerWithNextMove = 0;

        this.totalMovesTillNow = 0;
    }

    public void playGame() {
        // if a player wins we stop the game
        // 
        // else check if there is space remaining on the board for next player
        // if not, game is drawn as we have not winner and no space left    
        while(playingBoard.getWinner(players) == null || totalMovesTillNow < playingBoard.size * playingBoard.size) {
            
            // display the board
            playingBoard.displayBoard();

            // player whose turn it is
            Player currTurnPlayer = this.players.get(playerWithNextMove);

            // take user input
            int []position = playerInput(currTurnPlayer);

            boolean success = playingBoard.playAPiece(position[0], position[1], currTurnPlayer);

            if (!success) {
                // some error, let player try again
                continue;
            }

            // check if any player won the game
            Player winningPlayer = playingBoard.getWinner(players);

            if (winningPlayer != null) {
                // finally display board once
                playingBoard.displayBoard();

                System.out.println(winningPlayer.getName() + " won!!");
                break;
            }

            // one more space filled 
            totalMovesTillNow++;

            if (totalMovesTillNow == playingBoard.size * playingBoard.size) {
                System.out.println("Game is draw!");
                return;
            }

            // next players turn
            playerWithNextMove = (playerWithNextMove + 1) % this.players.size();
        }
    }

    public int[] playerInput(Player player) {
        // prompt for input
        System.out.println("Enter row, col: " + player.getName() + " : ");

        // take player input
        String input = this.scanner.nextLine();

        String[] splitValues = input.split(",");

        if (splitValues.length != 2) {
            System.err.println("Error: invalid input, please enter again");
            return this.playerInput(player);
        }

        int [] values = new int[2];

        values[0] = Integer.parseInt(splitValues[0].trim());
        values[1] = Integer.parseInt(splitValues[1].trim());

        return values;
    }
}
