package Examples.SnakeAndLadder;

public class Player {
    private int ID;
    private String name;
    int currentPosition = 0;

    public Player(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void advance(int steps) {
        this.setCurrentPosition(currentPosition + steps);
    }

    // Getters and Setters

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    
}
