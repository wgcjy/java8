package java.org.way.exmple.java8;

import java.time.*;

/**
 * Created by way on 2017/12/21.
 * <p>
 * 第三方库Joda-Time，替代Java的时间管理API。Java 8中新的时间和日期管理API深受Joda-Time影响，并吸收了很多Joda-Time的精华。新的java.time包包含了所有关于日期、时间、时区、Instant（跟日期类似但是精确到纳秒）、duration（持续时间）和时钟操作的类。新设计的API认真考虑了这些类的不变性（从java.util.Calendar吸取的教训），如果某个实例需要修改，则返回一个新的对象。
 */
public class TimeTester {

    public static void main(String[] args) {
        //Clock类使用时区来返回当前的纳秒时间和日期。Clock可以替代System.currentTimeMillis()和TimeZone.getDefault()。
        // Get the system clock as UTC offset
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        //关注下LocalDate和LocalTime类。LocalDate仅仅包含ISO-8601日历系统中的日期部分；LocalTime则仅仅包含该日历系统中的时间部分。这两个类的对象都可以使用Clock对象构建得到。
        // Get the local date and local time
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);

        System.out.println(date);
        System.out.println(dateFromClock);

// Get the local date and local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);

        System.out.println(time);

        //ZoneDateTime
        // Get the zoned date/time
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );

        System.out.println( zonedDatetime );
        System.out.println( zonedDatetimeFromClock );
        System.out.println( zonedDatetimeFromZone );


        //Duration类，它持有的时间精确到秒和纳秒。这使得我们可以很容易得计算两个日期之间的不同，
        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
    }
}
