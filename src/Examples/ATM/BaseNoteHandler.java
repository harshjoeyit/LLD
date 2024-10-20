package Examples.ATM;

public class BaseNoteHandler implements NoteHandler {
    // next note handler
    NoteHandler next;
    // note value
    int note;
    // number of notes available in ATM
    int notesAvailable;

    public BaseNoteHandler(int note, int notesAvailable) {
        this.note = note;
        this.notesAvailable = notesAvailable;
    }

    @Override
    public void setNext(NoteHandler handler) {
        this.next = handler;
    }

    @Override
    public void dispense(int amount) {
        int noteCount = amount / this.note;

        // check if this.notes can be dispensed
        if (noteCount > 0 && this.notesAvailable > 0) {
            // check if remaining notes are not enough to fullfill the need
            if (this.notesAvailable < noteCount) {
                noteCount = this.notesAvailable;
            }

            // dispense noteCount notes
            System.out.println(this.note + " X " + noteCount);
            
            // update notes available
            this.setNotesAvailable(this.notesAvailable - noteCount);
        }

        int amountCovered = noteCount * this.note;
        int remAmount = amount - amountCovered;

        if (remAmount > 0) {
            if (this.next != null) {
                this.next.dispense(remAmount);
            } else {
                if (remAmount % this.note == 0) {
                    System.err.println("Not enough funds" + ", short of: " + remAmount);
                } else {
                    System.out.println("Amount: " + remAmount + "cannot be dispensed as amount is not in multiples of available note values");
                }
            }
        }
    }

    // setters and getters

    public void setNotesAvailable(int notesAvailable) {
        this.notesAvailable = notesAvailable;
    }

    public int getNotesAvailable() {
        return this.notesAvailable;
    }
}
