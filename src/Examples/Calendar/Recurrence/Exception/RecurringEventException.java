package Examples.Calendar.Recurrence.Exception;

import Examples.Calendar.Event;

public class RecurringEventException {
    String exceptionId; 
    
    // start date time of the original recurring instance
    // will be used for lookup
    // LocalDateTime startTime;

    ExceptionType exceptionType;    // UPDATE or DELETE

    Event updatedEvent;             // null if exceptionType is Delete, else updated event 

    // constructor
    public RecurringEventException(String exceptionId, ExceptionType exceptionType, Event updatedEvent) {
        this.exceptionId = exceptionId;
        this.exceptionType = exceptionType;
        this.updatedEvent = updatedEvent;
    }

    @Override
    public String toString() {
        String s = "\n-------Exception----------";
        s += "\nexceptionId: " + exceptionId;
        s += "\nexceptionType: " + exceptionType;
        s += "\nupdated event title: " + updatedEvent.getTitle();
        s += "\n------------------------------";

        return s;
    }

    // Getters and Setters

    public ExceptionType getExceptionType() {
        return this.exceptionType;
    }

    public Event getUpdatedEvent() {
        return updatedEvent;
    }
}
