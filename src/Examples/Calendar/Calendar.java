package Examples.Calendar;

import java.util.Map;

// import Examples.Calendar.Recurrence.DayOfWeek;
import Examples.Calendar.Recurrence.RecurrencePattern;
import Examples.Calendar.Recurrence.RecurringEventUpdateType;
import Examples.Calendar.Recurrence.Exception.ExceptionType;
import Examples.Calendar.Recurrence.Exception.RecurringEventException;
import Examples.Calendar.Recurrence.MonthlyRecurrence.RecurrenceRule;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.DayOfWeek;

public class Calendar {
    // Events created by the user / user is organizer
    Map<String, Event> events = new HashMap<>();
    // Events to which user is invited
    Map<String, Event> invitations = new HashMap<>();

    // Constructor
    public Calendar() {
    };

    // Methods
    
    public void inviteGuest(Event event, User guest) {
        event.addGuest(guest);
    }

    public void removeGuest(Event event, User guest) {
        event.removeGuest(guest);
    }

    // add an event
    public void addEvent(Event event) {
        this.events.put(event.getEventId(), event);
    }

    // update event
    public void updateEvent(
            String eventId,
            Event updatedEvent,
            RecurringEventUpdateType updateType,
            LocalDateTime originalEventInstanceStartTime) {

        Event originalEvent = this.events.get(eventId);

        if (!originalEvent.getIsRecurring()) {
            // if one-time event, update right away
            events.put(eventId, updatedEvent);
            return;
        }

        // if recurring event, update based on - updateType

        // if updateType is THIS_AND_FOLLOWING,
        // 1. create a new recurring Event
        // 2. update the end date for existing recurring event
        if (updateType == RecurringEventUpdateType.THIS_AND_FOLLOWING) {

            // todo: find how many iterations completed and what remains
            // if this event had iterations defined (not null)
            int remainingIterations = updatedEvent.getIterations();

            // 1. new recurringEvent
            Event.EventBuilder builder = new Event.EventBuilder();
            Event newRecurringEvent = builder.setEventId(ID.genEventID())
                    .setTitle(updatedEvent.getTitle())
                    .setStartTime(updatedEvent.getStartTime())
                    .setEndTime(updatedEvent.getEndTime())
                    .setRecurring(updatedEvent.getIsRecurring())
                    .setRecurrencePattern(updatedEvent.getRecurrencePattern())
                    .setRecurrenceEnd(updatedEvent.getRecurrenceEndDateTime())
                    .setIterations(remainingIterations)
                    .build();

            this.addEvent(newRecurringEvent);

            // 2. update end date for existing recurring event
            // we end the recurrance 1 second before the start of first instance of updated event
            LocalDateTime newRecurrenceEndTime = updatedEvent.getStartTime().minusSeconds(1);
            originalEvent.setEndTime(newRecurrenceEndTime);
        }

        // if updateType is ONLY_THIS_INSTANCE
        // create a new one-time event and add the original startTime of instance to
        // exception list
        else if (updateType == RecurringEventUpdateType.ONLY_THIS_INSTANCE) {
            Event.EventBuilder builder = new Event.EventBuilder();
            Event newOneTimeEvent = builder.setEventId(ID.genEventID())
                    .setTitle(updatedEvent.getTitle())
                    .setStartTime(updatedEvent.getStartTime())
                    .setEndTime(updatedEvent.getEndTime())
                    .setRecurring(false)
                    .build();

            // add to event list as one time event
            this.addEvent(newOneTimeEvent);

            // add exception
            RecurringEventException exception = new RecurringEventException(
                    eventId,
                    ExceptionType.UPDATE_EVENT,
                    newOneTimeEvent);

            originalEvent.addException(originalEventInstanceStartTime, exception);
        }

        // if eventType is ALL
        // update the current recurring event
        else if (updateType == RecurringEventUpdateType.ALL) {
            originalEvent.setTitle(updatedEvent.getTitle());
            originalEvent.setStartTime(updatedEvent.getStartTime());
            originalEvent.setEndTime(updatedEvent.getEndTime());
            originalEvent.setRecurring(updatedEvent.getIsRecurring());
            originalEvent.setRecurrencePattern(updatedEvent.getRecurrencePattern());
            originalEvent.setRecurrenceEnd(updatedEvent.getRecurrenceEndDateTime());
            originalEvent.setIterations(updatedEvent.getIterations());
            originalEvent.setExceptions(new HashMap<>());

        } else {
            System.out.println("Invalid reccurring event update type");
        }
    }

    // delete an event
    public void deleteEvent(
            String eventId,
            RecurringEventUpdateType updateType,
            LocalDateTime originalEventInstanceStartTime) {

        Event originalEvent = this.events.get(eventId);

        if (!originalEvent.getIsRecurring()) {
            // if one-time event, update right away
            events.remove(eventId);
            return;
        }

        // if recurring event, delete based on - updateType

        if (updateType == RecurringEventUpdateType.THIS_AND_FOLLOWING) {
            // update end date for existing recurring event
            // we end the recurrance 1 second before the next iteration
            LocalDateTime newRecurrenceEndTime = originalEvent.getRecurrenceEndDateTime().minusSeconds(1);
            originalEvent.setEndTime(newRecurrenceEndTime);
        }

        else if (updateType == RecurringEventUpdateType.ONLY_THIS_INSTANCE) {
            // add exception that this instance is deleted
            RecurringEventException exception = new RecurringEventException(
                    eventId,
                    ExceptionType.DELETE_EVENT,
                    null);

            originalEvent.addException(originalEventInstanceStartTime, exception);
        }

        else if (updateType == RecurringEventUpdateType.ALL) {
            // delete recurring event
            events.remove(eventId);
        }
    }

    // Regardless of the view, user is always selected a day while viewing calendar
    // (e.g. 25th Oct 2024)
    // when he requests for a change in view, we use this date to find daily, weekly
    // or montly view
    public List<EventInstance> viewCalendar(LocalDateTime currentDateTime, CalendarViewType viewType) {
        LocalDateTime start, end;
        start = end = LocalDateTime.now(); // default window

        switch (viewType) {
            case DAY:
                // Get the first moment of the day
                start = currentDateTime
                        .withHour(0)
                        .withMinute(0)
                        .withSecond(0)
                        .withNano(0);

                // Get the last moment of the day
                end = currentDateTime
                        .withHour(23)
                        .withMinute(59)
                        .withSecond(59)
                        .withNano(999_999_999);
                break;

            case WEEK:
                // Get the first moment of the week (first hour, first minute, first second)
                start = currentDateTime
                        .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                        .withHour(0)
                        .withMinute(0)
                        .withSecond(0)
                        .withNano(0);

                // Get the last moment of the week (last hour, last minute, last second)
                end = currentDateTime
                        .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))
                        .withHour(23)
                        .withMinute(59)
                        .withSecond(59)
                        .withNano(999_999_999);
                break;

            case MONTH:
                // First moment of the month
                start = currentDateTime
                        .with(TemporalAdjusters.firstDayOfMonth())
                        .withHour(0)
                        .withMinute(0)
                        .withSecond(0)
                        .withNano(0);

                // Last moment of the month
                end = currentDateTime
                        .with(TemporalAdjusters.lastDayOfMonth())
                        .withHour(23)
                        .withMinute(59)
                        .withSecond(59)
                        .withNano(999_999_999);
                break;

            default:
                System.out.println("Invalid calendar view type requested");
        }

        return getEventsInWindow(start, end);
    }

    // returns all events, one-time and recurring instances
    private List<EventInstance> getEventsInWindow(LocalDateTime start, LocalDateTime end) {
        // find events where start <= event start time < end
        List<EventInstance> eventsInWindow = new ArrayList<>();

        for (Event event : events.values()) {
            if (event.getIsRecurring()) {
                // System.out.println("recurring event found: " + event.getEventId());

                // skip the recurring event if it's already ended
                LocalDateTime endDateTime = event.getRecurrenceEndDateTime();
                if (endDateTime != null && endDateTime.isBefore(start)) {
                    continue;
                }

                // System.out.println("recurring event not skipped: " + event.getEventId());

                // find all recurrance with exceptions
                List<EventInstance> reccurances = this.getOccurrences(event, start, end);
                eventsInWindow.addAll(reccurances);

            } else {
                // One-time events

                LocalDateTime startTime = event.getStartTime();

                // event start time should fall into the requested window

                if (startTime.isAfter(start) && startTime.isBefore(end)) {
                    eventsInWindow.add(EventInstance.toEventInstance(event));
                }
            }
        }

        return eventsInWindow;
    }

    // getOccurrences returns a list of event instances for a recurring event in a
    // time window
    private List<EventInstance> getOccurrences(Event recurringEvent, LocalDateTime start, LocalDateTime end) {
        List<EventInstance> occurrences = new ArrayList<>();

        LocalDateTime currentStartTime = recurringEvent.getStartTime();
        Duration eventDuration = Duration.between(recurringEvent.getStartTime(), recurringEvent.getEndTime());

        // and the recurring event ends before the window, we don't go further
        LocalDateTime recurrenceEnd = recurringEvent.getRecurrenceEndDateTime();
        if (recurrenceEnd != null && recurrenceEnd.isBefore(end)) {
            end = recurrenceEnd;
        }

        // untill we go out of the window
        while (currentStartTime.isBefore(end)) {

            if (currentStartTime.isBefore(start)) {
                // the occurance falls out of the window
                currentStartTime = this.nextOccurrence(currentStartTime, recurringEvent.getRecurrencePattern());
                continue;
            }

            // now here, start < currentStartTime < end

            // handling rescheduled or deleted instances

            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // System.out.println("event title: " + recurringEvent.getTitle());
            // System.out.println("size of exceptions: " + recurringEvent.getExceptions().size());
            // System.out.println("searching for key: " + currentStartTime.format(formatter));

            if (recurringEvent.getExceptions().containsKey(currentStartTime)) {
                
                // if exception is of type - update, then updated event would already be added to events list
                // if exception type is delete, the instance would be deleted so we can ignore

                // // exception found for the start time of this occurance

                // RecurringEventException exception = recurringEvent.getExceptions().get(currentStartTime);

                // if (exception.getExceptionType() == ExceptionType.UPDATE_EVENT) {
                //     // check if the updated event falls in the window, if yes add to the list
                //     Event updatedEvent = exception.getUpdatedEvent();
                //     LocalDateTime updatedEventStartTime = updatedEvent.getStartTime();

                //     if (updatedEventStartTime.isAfter(start) && updatedEventStartTime.isBefore(end)) {
                //         // since this is an exception mark is as non recurring
                //         updatedEvent.setRecurring(false);
                //         occurrences.add(EventInstance.toEventInstance(updatedEvent));
                //     }
                // }
                // // else - the event was deleted, so we can simply ignore

            } else {
                // no exception
                // System.out.println("not found");

                EventInstance eventInstance = new EventInstance(
                        ID.genEventID(),
                        recurringEvent.getTitle(),
                        currentStartTime,
                        currentStartTime.plus(eventDuration),
                        true);

                occurrences.add(eventInstance);
            }

            currentStartTime = this.nextOccurrence(currentStartTime, recurringEvent.getRecurrencePattern());

        }

        return occurrences;
    }

    private LocalDateTime nextOccurrence(LocalDateTime current, RecurrencePattern recurrencePattern) {
        int interval = recurrencePattern.getInterval();

        switch (recurrencePattern.getType()) {
            case DAILY:
                return nextDailyOccurrence(current, interval);
            case WEEKLY:
                return nextWeeklyOccurrence(current, interval, recurrencePattern.getDaysOfWeek());
            case MONTHLY:
                return nextMonthlyOccurence(current, interval, recurrencePattern.getMonthlyRecurrenceRule());
            case ANNUALY:
                return nextAnnuallyOccurence(current, interval);
        }

        return null;
    }

    private LocalDateTime nextDailyOccurrence(LocalDateTime current, int interval) {
        return current.plusDays(interval);
    }

    private LocalDateTime nextWeeklyOccurrence(LocalDateTime current, int interval, List<DayOfWeek> daysOfWeek) {
        // Case 1:
        // next occurrance could be in this week iteslf, when event recurs more than
        // onces a week. For eg. Mon, Fri every 2 weeks

        // taking safe assumption that daysOfWeek list is not ordered - MON followed by
        // TUE, and so on
        // we find the first day of the recurrence after interval weeks.

        // taking Next Monday as upper limit for finding next recurrance in the SAME
        // week
        LocalDateTime nextMonday = current.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).plusWeeks(1);
        LocalDateTime nextRecurranceInWeek = nextMonday;

        // minimize nextRecurranceInWeek
        for (DayOfWeek dayOfWeek : daysOfWeek) {
            LocalDateTime occurance = current.with(TemporalAdjusters.nextOrSame(dayOfWeek));

            // MUST be after current occurance
            if (!occurance.isAfter(current)) {
                continue;
            }

            if (occurance.isBefore(nextRecurranceInWeek)) {
                nextRecurranceInWeek = occurance;
            }
        }

        if (!nextRecurranceInWeek.equals(nextMonday)) {
            // found next occurance in the same week
            return nextRecurranceInWeek;
        }

        // Case 2:
        // next occurance is after "interval" weeeks since we did not find any in the
        // same week

        // shifting current to Monday after interval weeks
        current = current
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .plusWeeks(interval);
        nextMonday = current.plusWeeks(1);
        LocalDateTime firstRecurranceInWeek = nextMonday;

        // minimize firstRecurranceInWeek to find first occurence
        for (DayOfWeek dayOfWeek : daysOfWeek) {
            LocalDateTime occurance = current.with(TemporalAdjusters.nextOrSame(dayOfWeek));
            if (occurance.isBefore(firstRecurranceInWeek)) {
                firstRecurranceInWeek = occurance;
            }
        }

        return firstRecurranceInWeek;
    }

    private LocalDateTime nextMonthlyOccurence(LocalDateTime current, int interval, RecurrenceRule rule) {
        LocalDateTime dateAfterIntervalMonths = current.plusMonths(interval);

        switch (rule.getRuleType()) {
            case SAME_DATE:
                int specificDay = current.getDayOfMonth();
                return dateAfterIntervalMonths.withDayOfMonth(specificDay);

            case NTH_DAY_OF_WEEK:
                int nthOccurrence = rule.getNthOccurrence();
                DayOfWeek day = rule.getDayOfWeek();

                return dateAfterIntervalMonths.with(
                        TemporalAdjusters.dayOfWeekInMonth(nthOccurrence, day));
        }

        return null;
    }

    private LocalDateTime nextAnnuallyOccurence(LocalDateTime current, int interval) {
        return current.plusYears(interval);
    }
}
