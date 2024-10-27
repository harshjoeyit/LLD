package Examples.Calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import Examples.Calendar.Recurrence.RecurrencePattern;
import Examples.Calendar.Recurrence.Exception.RecurringEventException;
import Examples.Calendar.Recurrence.MonthlyRecurrence.RecurrenceRule;

public class Event {
    private String eventId;
    private String title;
    private LocalDateTime startTime; // for recurring event, refers to start time first instance
    private LocalDateTime endTime; // for recurring event, refers to end time of first instance

    // private User organizer; // The creator of the event
    // private List<User> guests; // Users invited to the event

    private boolean isRecurring; // True for recurring events
    private RecurrencePattern recurrencePattern;
    private LocalDateTime recurrenceEnd; // optional, for recurring events
    private int iterations; // optional, for recurring events to end after a set number

    // for rescheduled or deleted instances for recurring events
    private Map<LocalDateTime, RecurringEventException> exceptions;

    // private constructor
    private Event(EventBuilder builder) {
        this.eventId = builder.eventId;
        this.title = builder.title;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.isRecurring = builder.isRecurring;
        this.recurrencePattern = builder.recurrencePattern;
        this.recurrenceEnd = builder.recurrenceEnd;
        this.iterations = builder.iterations;
        this.exceptions = builder.exceptions;
    }

    // Builder class
    public static class EventBuilder {
        private String eventId;
        private String title;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private boolean isRecurring;
        private RecurrencePattern recurrencePattern;
        private LocalDateTime recurrenceEnd;
        private int iterations;
        // Map <start time of event, exception object>
        // A new event has no exceptions
        private Map<LocalDateTime, RecurringEventException> exceptions = new HashMap<>();

        public EventBuilder setEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public EventBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public EventBuilder setStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public EventBuilder setEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public EventBuilder setRecurring(boolean isRecurring) {
            this.isRecurring = isRecurring;
            return this;
        }

        public EventBuilder setRecurrencePattern(RecurrencePattern recurrencePattern) {
            this.recurrencePattern = recurrencePattern;
            return this;
        }

        public EventBuilder setRecurrenceEnd(LocalDateTime recurrenceEnd) {
            this.recurrenceEnd = recurrenceEnd;
            return this;
        }

        public EventBuilder setIterations(int iterations) {
            this.iterations = iterations;
            return this;
        }

        public EventBuilder setExceptions(Map<LocalDateTime, RecurringEventException> exceptions) {
            this.exceptions = exceptions;
            return this;
        }

        // build
        public Event build() {
            return new Event(this);
        }
    }

    // Methods

    public void addException(LocalDateTime startTime, RecurringEventException exception) {
        exceptions.put(startTime, exception);
    }

    public void addGuest(User guest) {
        // todo
    }

    public void removeGuest(User guest) {
        // todo
    }

    public void setRecurrence(
            RecurrencePattern pattern,
            RecurrenceRule rule,
            LocalDateTime end,
            int iterations) {
        // todo
    }

    // clone
    @Override
    protected Event clone() {
        EventBuilder builder = new EventBuilder();
        Event cloned = builder.setEventId(ID.genEventID())
                .setTitle(this.title)
                .setStartTime(this.startTime)
                .setEndTime(this.endTime)
                .setRecurring(this.isRecurring)
                .setRecurrencePattern(this.recurrencePattern)
                .setRecurrenceEnd(this.recurrenceEnd)
                .setIterations(this.iterations)
                .build();

        return cloned;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s = "\n------------------------";
        s += "\neventId: " + eventId;
        s += "\ntitle: " + title;
        s += "\nstart time: " + startTime.format(formatter);
        s += "\nend time: " + endTime.format(formatter);
        s += "\nrecurring? : " + isRecurring;
        s += "\n------------------------";

        return s;
    }

    // Getters and setters

    public String getEventId() {
        return this.eventId;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public RecurrencePattern getRecurrencePattern() {
        return this.recurrencePattern;
    }

    public LocalDateTime getRecurrenceEndDateTime() {
        return this.recurrenceEnd;
    }

    public int getIterations() {
        return this.iterations;
    }

    public Map<LocalDateTime, RecurringEventException> getExceptions() {
        return this.exceptions;
    }

    public boolean getIsRecurring() {
        return this.isRecurring;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setRecurring(boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public void setRecurrencePattern(RecurrencePattern recurrencePattern) {
        this.recurrencePattern = recurrencePattern;
    }

    public void setRecurrenceEnd(LocalDateTime recurrenceEnd) {
        this.recurrenceEnd = recurrenceEnd;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void setExceptions(Map<LocalDateTime, RecurringEventException> exceptions) {
        this.exceptions = exceptions;
    }
}
