package Examples.ATM;

public interface NoteHandler {
    public void setNext(NoteHandler handler);
    public void dispense(int amount);
}
