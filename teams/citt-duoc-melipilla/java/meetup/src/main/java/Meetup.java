import java.time.DayOfWeek;
import java.time.LocalDate;

public class Meetup {

    private final LocalDate baseDate;

    Meetup(int month, int year) {
        baseDate = LocalDate.of(year, month, 1);
    }

    LocalDate day(DayOfWeek weekDay, MeetupSchedule meetupSchedule) {
        int iterations = getNumberOfIteratios(meetupSchedule);
        int day;
        if (iterations != -1) {
            day = findTheNDayOfTheMonth(iterations, weekDay);
        } else {
            day = findTheTeenthDayOfMonth(weekDay);
        }
        return baseDate.plusDays(--day);
    }

    private int findTheTeenthDayOfMonth(DayOfWeek weekDay) {
        for (int day = 13; day <= baseDate.lengthOfMonth(); day++) {
            if (LocalDate.of(baseDate.getYear(), baseDate.getMonth(), day).getDayOfWeek() == weekDay) {
                return day;
            }
        }
        return 1;
    }

    private int findTheNDayOfTheMonth(int iterations, DayOfWeek weekDay) {
        int matches = 0; //Count how many times we have found the day in the month
        int nDay = 1;
        final int numberOfDaysInMonth = baseDate.lengthOfMonth();
        final int year = baseDate.getYear();
        final int month = baseDate.getMonthValue();
        for (int day = 1; day <= numberOfDaysInMonth && iterations != matches; day++) {
            if (LocalDate.of(year, month, day).getDayOfWeek() == weekDay) {
                matches++;
                nDay = day;
            }
        }
        return nDay;
    }

    private int getNumberOfIteratios(MeetupSchedule meetupSchedule) {
        switch (meetupSchedule) {
            case FIRST: return 1;
            case SECOND: return 2;
            case THIRD: return 3;
            case FOURTH: return 4;
            case LAST: return 32;
            default: return -1;
        }
    }
}