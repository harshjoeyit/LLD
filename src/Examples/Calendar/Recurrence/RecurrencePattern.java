package Examples.Calendar.Recurrence;

import java.util.List;
import java.time.DayOfWeek;

import Examples.Calendar.Recurrence.MonthlyRecurrence.RecurrenceRule;


public class RecurrencePattern {
    private static final int DEFAULT_INTERVAL = 1; 
    private RecurrenceType type; // DAILY, WEEKLY, MONTHLY, ANNUALLY
    private int interval; // Every X days, weeks, months, or years
    private List<DayOfWeek> daysOfWeek; // Used for weekly recurrence (multi-select)
    private RecurrenceRule monthlyRecurranceRule; // Same day of the month or first/second Tuesday, etc.

    // Constructor, getters, and setters
    public RecurrencePattern(
            RecurrenceType type,
            int interval,
            List<DayOfWeek> daysOfWeek,
            RecurrenceRule monthlyRecurranceRule) {

        this.type = type;
        this.daysOfWeek = daysOfWeek;
        this.monthlyRecurranceRule = monthlyRecurranceRule;

        if (interval <= 0) {
            this.interval = DEFAULT_INTERVAL;
        } else {
            this.interval = interval;
        }
    }

    // Getters and Setters

    public RecurrenceType getType() {
        return type;
    }

    public void setType(RecurrenceType type) {
        this.type = type;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public List<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<DayOfWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public RecurrenceRule getMonthlyRecurrenceRule() {
        return monthlyRecurranceRule;
    }

    public void setMonthlyRecurrenceRuleRule(RecurrenceRule monthRecurrenceRule) {
        this.monthlyRecurranceRule = monthRecurrenceRule;
    }
}
