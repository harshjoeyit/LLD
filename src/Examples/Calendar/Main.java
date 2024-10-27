package Examples.Calendar;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import Examples.Calendar.Recurrence.RecurrencePattern;
import Examples.Calendar.Recurrence.RecurrenceType;
import Examples.Calendar.Recurrence.RecurringEventUpdateType;
import Examples.Calendar.Recurrence.Exception.RecurringEventException;
import Examples.Calendar.Recurrence.MonthlyRecurrence.RecurrenceRule;
import Examples.Calendar.Recurrence.MonthlyRecurrence.RuleType;

public class Main {

    public static void displayCalendar(List<EventInstance> events) {
        for (EventInstance event : events) {
            System.out.println(event.toString());
        }
        System.out.println("\nTotal events: " + events.size());
    }

    public static void displayExceptions(Map<LocalDateTime, RecurringEventException> exceptions) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Map.Entry<LocalDateTime, RecurringEventException> entry : exceptions.entrySet()) {
            System.out.println(entry.getKey().format(formatter) + "\n" + entry.getValue().toString());
        }
    }

    public static void demoOneTimeEvents(User u1) {
        LocalDateTime now = LocalDateTime.now();
        Event.EventBuilder eventBuilder = new Event.EventBuilder();
        
        // one time events

        Event e1 = eventBuilder.setEventId(ID.genEventID())
        .setTitle("First event")
        .setStartTime(now.plusMinutes(30))
        .setEndTime(now.plusMinutes(60))
        .setRecurring(false)
        .build();

        Event e2 = eventBuilder.setEventId(ID.genEventID())
        .setTitle("Second event")
        .setStartTime(now.plusDays(1))
        .setEndTime(now.plusDays(1).plusHours(2))
        .setRecurring(false)
        .build();
        
        Event e3 = eventBuilder.setEventId(ID.genEventID())
        .setTitle("Third event")
        .setStartTime(now.plusWeeks(1))
        .setEndTime(now.plusWeeks(1).plusHours(1))
        .setRecurring(false)
        .build();
    
        Event e4 = eventBuilder.setEventId(ID.genEventID())
        .setTitle("Fourth event")
        .setStartTime(now.plusDays(5))
        .setEndTime(now.plusWeeks(1).plusHours(3))
        .setRecurring(false)
        .build();
        
        u1.getCalendar().addEvent(e1);
        u1.getCalendar().addEvent(e2);
        u1.getCalendar().addEvent(e3);
        u1.getCalendar().addEvent(e4);

    }

    public static void demoDailyRecurring(User u1) {
        LocalDateTime now = LocalDateTime.now();
        Event.EventBuilder eventBuilder = new Event.EventBuilder();

        // daily recurring event
        RecurrencePattern rp1 = new RecurrencePattern(
            RecurrenceType.DAILY, 
            1,
            null, 
            null);

        Event e5 = eventBuilder.setEventId(ID.genEventID())
        .setTitle("Fifth event (daily recurring)")
        .setStartTime(now)
        .setEndTime(now.plusHours(1))
        .setRecurring(true)
        .setRecurrencePattern(rp1)
        .build();

        u1.getCalendar().addEvent(e5);
        
        // update a instance

        RecurringEventUpdateType updateType = RecurringEventUpdateType.ONLY_THIS_INSTANCE;
        LocalDateTime originalStartTime = now.plusDays(2);                   // updating the instance which is 2 days from now
        LocalDateTime updatedStartTime = originalStartTime.plusHours(3);    // postpone by 3 hours
        LocalDateTime updatedEndTime = updatedStartTime.plusHours(2);       // set duration of 2 hours
        String updatedTitle = "updated Fifth event";

        Event updatedEvent = e5.clone();
        updatedEvent.setTitle(updatedTitle);
        updatedEvent.setStartTime(updatedStartTime);
        updatedEvent.setEndTime(updatedEndTime);

        u1.getCalendar().updateEvent(e5.getEventId(), updatedEvent, updateType, originalStartTime);

        // delete a instance
        updateType = RecurringEventUpdateType.ONLY_THIS_INSTANCE;
        originalStartTime = now.plusDays(3);   // delete instance which is 3 days from now
        u1.getCalendar().deleteEvent(e5.getEventId(), updateType, originalStartTime);

        // for next week
        // displayCalendar(u1.getCalendar().viewCalendar(now.plusWeeks(1), CalendarViewType.WEEK));
    }

    public static void demoWeeklyRecurring(User u1) {
        LocalDateTime now = LocalDateTime.now();
        Event.EventBuilder eventBuilder = new Event.EventBuilder();
        
        List<DayOfWeek> daysOfWeek = new ArrayList<>(
            Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.FRIDAY)
        );

        RecurrencePattern rp2 = new RecurrencePattern(
            RecurrenceType.WEEKLY, 
            1,
            daysOfWeek, 
            null);

        // next week Monday same time as now
        LocalDateTime start = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        // LocalDateTime start = now;

        Event e6 = eventBuilder.setEventId(ID.genEventID())
            .setTitle("Sixth event (weekly recurring)")
            .setStartTime(start)
            .setEndTime(start.plusHours(1))
            .setRecurring(true)
            .setRecurrencePattern(rp2)
            .build();
        
        u1.getCalendar().addEvent(e6);

        // displayCalendar(u1.getCalendar().viewCalendar(now.plusWeeks(1), CalendarViewType.WEEK));
    }

    public static void demoMonthlyRecurring(User u1) {
        LocalDateTime now = LocalDateTime.now();
        Event.EventBuilder eventBuilder = new Event.EventBuilder();

        // monthly recurrence rule
        RecurrenceRule rule = new RecurrenceRule(RuleType.SAME_DATE, null, 0);
        // RecurrenceRule rule = new RecurrenceRule(RuleType.NTH_DAY_OF_WEEK, DayOfWeek.SUNDAY, 1);
        int interval = 1;

        RecurrencePattern rp3 = new RecurrencePattern(
            RecurrenceType.MONTHLY, 
            interval,
            null, 
            rule);

        // next week Monday same time as now
        LocalDateTime start = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        // LocalDateTime start = now;

        Event e7 = eventBuilder.setEventId(ID.genEventID())
            .setTitle("Seventh event (monthly recurring)")
            .setStartTime(start)
            .setEndTime(start.plusHours(1))
            .setRecurring(true)
            .setRecurrencePattern(rp3)
            .build();
        
        u1.getCalendar().addEvent(e7);

        // displayCalendar(u1.getCalendar().viewCalendar(now.plusMonths(1), CalendarViewType.MONTH));
        // displayCalendar(u1.getCalendar().viewCalendar(now.plusMonths(2), CalendarViewType.MONTH));
        // displayCalendar(u1.getCalendar().viewCalendar(now.plusMonths(3), CalendarViewType.MONTH));
    }

    

    public static void main() {
        Calendar c1 = new Calendar();
        User u1 = new User(ID.genUserID(), "user1", "user1@a.com", c1);
        
        LocalDateTime now = LocalDateTime.now();

        // demoOneTimeEvents(u1);
        demoDailyRecurring(u1);
        // demoWeeklyRecurring(u1);
        // demoMonthlyRecurring(u1);

        // for next month
        displayCalendar(u1.getCalendar().viewCalendar(now.plusWeeks(1), CalendarViewType.WEEK));
    }
}
