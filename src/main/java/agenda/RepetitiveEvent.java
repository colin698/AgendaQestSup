package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

    public ChronoUnit frequency;
    private final ArrayList<LocalDate> lesExceptions = new ArrayList<>();

    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        lesExceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        LocalDate dateBoucle = this.getStart().toLocalDate();
        if (lesExceptions.contains(aDay)) {
            return false;
        }
        while (aDay.isEqual(dateBoucle) || aDay.isAfter(dateBoucle)) {
            if (aDay.isEqual(dateBoucle)) {
                return true;
            }
            dateBoucle = dateBoucle.plus(1, frequency);
        }
        return true;
    }

} 