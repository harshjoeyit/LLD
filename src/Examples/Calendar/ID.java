package Examples.Calendar;

// Generates IDs based on counters
public class ID {
    private static int eventCounter;
    private static int userCounter;
    private static int exceptionCounter;

    public static String genEventID() {
        eventCounter++;
        return String.valueOf(eventCounter);
    }

    public static String genUserID() {
        userCounter++;
        return String.valueOf(userCounter);
    }

    public static String exceptionID() {
        exceptionCounter++;
        return String.valueOf(exceptionCounter);
    }
}
