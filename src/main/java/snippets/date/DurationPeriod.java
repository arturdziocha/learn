package snippets.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DurationPeriod {
    public static long[] getDurationPeriod(LocalDateTime firstLocalDateTime, LocalDateTime secondLocalDateTime) {
        long[] result = new long[6];
        LocalDate firstLocalDate, secondLocalDate;
        LocalTime firstLocalTime, secondLocalTime;
        if (firstLocalDateTime.isBefore(secondLocalDateTime)) {
            firstLocalDate = firstLocalDateTime.toLocalDate();
            firstLocalTime = firstLocalDateTime.toLocalTime();

            secondLocalDate = secondLocalDateTime.toLocalDate();
            secondLocalTime = secondLocalDateTime.toLocalTime();
        } else {
            firstLocalDate = secondLocalDateTime.toLocalDate();
            firstLocalTime = secondLocalDateTime.toLocalTime();

            secondLocalDate = firstLocalDateTime.toLocalDate();
            secondLocalTime = firstLocalDateTime.toLocalTime();
        }
        Duration duration = Duration.between(firstLocalTime, secondLocalTime);
        Period period = Period.between(firstLocalDate, secondLocalDate);

        if (secondLocalTime.isBefore(firstLocalTime)) {
            duration = duration.plusDays(1);
            period = period.minusDays(1);
        }
        result[0] = period.getYears();
        result[1] = period.getMonths();
        result[2] = period.getDays();
        result[3] = duration.toHours();
        result[4] = duration.toMinutes() % 60;
        result[5] = duration.getSeconds() % 60;
        return result;
    }
}
