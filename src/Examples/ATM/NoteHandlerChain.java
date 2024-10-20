package Examples.ATM;

// create note hanlder chain
public class NoteHandlerChain {
    public static NoteHandler getNoteHandlerChain() {
        // crete note handler
        NoteHandler handler2000 = new NoteHandler2000(2);
        NoteHandler handler500 = new NoteHandler500(5);
        NoteHandler handler100 = new NoteHandler100(10);

        // create chain
        handler2000.setNext(handler500);
        handler500.setNext(handler100);

        return handler2000;
    }
}
