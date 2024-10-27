package Examples.Calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
 * EventInstance is a concise representation of and Event object
 * This simple representation is for viewing events in Calendar 
 * Daily, Weekly, Monthly view
 */
class EventInstance {
    private String eventId;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isRecurring;

    // Constructor and Getter/Setter methods
    public EventInstance(
            String eventId,
            String title,
            LocalDateTime startTime,
            LocalDateTime endTime,
            boolean isRecurring) {

        this.eventId = eventId;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isRecurring = isRecurring;
    }

    // EventInstance from event
    public EventInstance(Event event) {
        // delegate to the first constructor
        this(
                event.getEventId(),
                event.getTitle(),
                event.getStartTime(),
                event.getEndTime(),
                event.getIsRecurring());
    }

    // convert a list of Event to EventInstances
    public static List<EventInstance> toEventInstances(List<Event> events) {
        List<EventInstance> eventInstances = new ArrayList<>();

        for (Event event : events) {
            EventInstance eventInstance = new EventInstance(event);
            eventInstances.add(eventInstance);
        }

        return eventInstances;
    }

    // convert Event to EventInstance
    public static EventInstance toEventInstance(Event event) {
        return new EventInstance(event);
    }

    // toString
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s = "------------------------";
        s += "\neventId: " + eventId;  
        s += "\ntitle: " + title;
        s += "\nstart time: " + startTime.format(formatter) + " [" + startTime.getDayOfWeek() + "]";
        s += "\nend time: " + endTime.format(formatter) + " [" + endTime.getDayOfWeek() + "]";
        s += "\nrecurring? : " + isRecurring;
        s += "\n------------------------";

        return s;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}