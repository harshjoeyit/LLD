package Examples.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Dice> dices;
    private List<Player> players;
    int currPlayerTurnIdx;

    public void startGame() {
        this.setupGame();

        while(true) {
            // current player rolls dice
            this.nextPlayerTurn();

            Player currPlayer = players.get(currPlayerTurnIdx);

            int diceSum = 0;
            for (int i=0; i<dices.size(); i++) {
                diceSum += dices.get(i).rollDice();
            }

            System.out.println("Player: " + currPlayer.getName() + " is at: " + currPlayer.currentPosition + " moves by: " + diceSum);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("failed to sleep");
            }

            currPlayer.advance(diceSum);

            if (isGameEnded()) {
                break;
            }

            int currPlayerPos = currPlayer.getCurrentPosition();

            // check if there is a snake at this position
            if (this.board.getSnakes().containsKey(currPlayerPos)) {
                int snakeTail = this.board.getSnakes().get(currPlayerPos).getTo();
                currPlayer.setCurrentPosition(snakeTail);
                System.out.println("snake bites and reachces " + snakeTail);
            }

            // check if there is a ladder at this position
            if (this.board.getLadders().containsKey(currPlayerPos)) {
                int ladderTop = this.board.getLadders().get(currPlayerPos).getTo();
                currPlayer.setCurrentPosition(ladderTop);
                System.out.println("takes ladder and reaches " + ladderTop);
            }

            if (isGameEnded()) {
                break;
            }
        }
    }

    public void setupGame() {
        // input board size
        int N = 10;
        this.board = new Board(N);

        this.board.addSnake(80, 21);
        this.board.addSnake(90, 5);

        this.board.addLadder(25, 70);
        this.board.addLadder(15, 60);

        // input count of dices
        int diceCount = 1;
        this.dices = new ArrayList<>();
        for (int i=1; i<=diceCount; i++) {
            this.dices.add(new Dice());
        }

        // input count of players
        this.players = new ArrayList<>();

        this.players.add(new Player(1, "Harshit"));
        this.players.add(new Player(2, "Joey"));

        this.currPlayerTurnIdx = -1;
    }


    // Give turn to next player
    public void nextPlayerTurn() {
        int totalPlayers = this.players.size();

        if (this.currPlayerTurnIdx == totalPlayers - 1 || this.currPlayerTurnIdx == -1) {
            this.currPlayerTurnIdx = 0;
        } else {
            this.currPlayerTurnIdx++;
        }
    }

    public boolean isGameEnded() {
        // End game when player with last move reached end
        if (players.get(currPlayerTurnIdx).getCurrentPosition() >= this.board.getWinningPosition()) {
            System.out.println("game over. winner: " + players.get(currPlayerTurnIdx).getName());
            return true;
        }

        return false;
    }
}
