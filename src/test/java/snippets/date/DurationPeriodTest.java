package snippets.date;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import snippets.date.DurationPeriod;

class DurationPeriodTest {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void testTheSameDate() {
        assertArrayEquals(new long[] { 0, 0, 0, 0, 0, 0 }, DurationPeriod
                .getDurationPeriod(LocalDateTime.of(2015, 9, 9, 21, 46, 44), LocalDateTime.of(2015, 9, 9, 21, 46, 44)));

    }

    @Test
    public void test1Hour() {
        assertArrayEquals(new long[] { 0, 0, 0, 1, 0, 0 },
            DurationPeriod
                    .getDurationPeriod(LocalDateTime.parse("2015-09-09 21:46:44", formatter),
                        LocalDateTime.parse("2015-09-09 22:46:44", formatter)));
    }

    @Test
    public void test23Hour() {
        assertArrayEquals(new long[] { 0, 0, 0, 23, 0, 0 },
            DurationPeriod
                    .getDurationPeriod(LocalDateTime.parse("2015-09-09 21:46:44", formatter),
                        LocalDateTime.parse("2015-09-10 20:46:44", formatter)));
    }

    @Test
    public void test1HourFirstBiger() {
        assertArrayEquals(new long[] { 0, 0, 0, 1, 0, 0 },
            DurationPeriod
                    .getDurationPeriod(LocalDateTime.parse("2015-09-09 21:46:44", formatter),
                        LocalDateTime.parse("2015-09-09 20:46:44", formatter)));
    }

    @Test
    public void test23HourFirstBigger() {
        assertArrayEquals(new long[] { 0, 0, 0, 23, 0, 0 },
            DurationPeriod
                    .getDurationPeriod(LocalDateTime.parse("2015-09-10 20:46:44", formatter),
                        LocalDateTime.parse("2015-09-09 21:46:44", formatter)));
    }

    @Test
    public void test1Day23Hours() {
        assertArrayEquals(new long[] { 0, 0, 1, 23, 0, 0 },
            DurationPeriod
                    .getDurationPeriod(LocalDateTime.parse("2015-09-11 20:46:44", formatter),
                        LocalDateTime.parse("2015-09-09 21:46:44", formatter)));
    }

    @Test
    public void test29YearsFirstSmaller() {
        assertArrayEquals(new long[] { 29, 8, 24, 12, 0, 50 },
            DurationPeriod
                    .getDurationPeriod(LocalDateTime.parse("1984-12-16 07:45:55", formatter),
                        LocalDateTime.parse("2014-09-09 19:46:45", formatter)));
    }

    @Test
    public void test29YearsSecondSmaller() {
        assertArrayEquals(new long[] { 29, 8, 24, 12, 0, 50 },
            DurationPeriod
                    .getDurationPeriod(LocalDateTime.parse("2014-09-09 19:46:45", formatter),
                        LocalDateTime.parse("1984-12-16 07:45:55", formatter)));
    }
}
