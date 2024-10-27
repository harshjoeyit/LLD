package Examples.Calendar.Recurrence.MonthlyRecurrence;

import java.time.DayOfWeek;

/*
 * 
"Same Date" Rule: RecurrenceRule rule = new RecurrenceRule(RuleType.SAME_DATE, null, 0);
This could represent an event that occurs on the 2nd day of each month.

"Nth Day of Week" Rule (e.g., Third Friday): RecurrenceRule rule = new RecurrenceRule(RuleType.NTH_DAY_OF_WEEK, DayOfWeek.FRIDAY, 3);
This could represent an event that occurs on the third Friday of each month.
 * 
 */
public class RecurrenceRule {
    private RuleType ruleType;  // E.g., SAME_DATE, FIRST_DAY_OF_WEEK, etc.
    private DayOfWeek dayOfWeek; // Used for specifying day in the week for weekly/monthly patterns
    private int nthOccurrence;   // For specifying "Nth occurrence of DayOfWeek", like 2nd or 3rd

    public RecurrenceRule(RuleType ruleType, DayOfWeek dayOfWeek, int nthOccurrence) {
        this.ruleType = ruleType;
        this.dayOfWeek = dayOfWeek;
        this.nthOccurrence = nthOccurrence;
    }

    // Getters and setters
    
    public RuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getNthOccurrence() {
        return nthOccurrence;
    }

    public void setNthOccurrence(int nthOccurrence) {
        this.nthOccurrence = nthOccurrence;
    }
}
