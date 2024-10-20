package Examples.ATM;

public class ATM {
    NoteHandler noteHandler;

    public ATM() {
        this.noteHandler = NoteHandlerChain.getNoteHandlerChain();
    }

    public void dispense(int amount) {
        // amount should multiple of 100s 
        // since that's the last note handler in the chain
        if (amount % 100 != 0) {
            System.out.println("error: amount should be multiple of 100.");    
            return;
        }

        this.noteHandler.dispense(amount);
    }

    // setters and getters
    // todo: to refill the notes in ATM
}
