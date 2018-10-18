package DateApi;

import java.time.*;
import java.util.Date;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-21 16:13
 **/
public class LocalTime01 {
    public static void main(String[] args) {

    }

    //01. java.util.Date --> java.time.LocalDateTime
    private static void test01() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);

    }

    //02. java.util.Date --> java.time.LocalDate
    private static void test02() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        LocalDate localDate = localDateTime.toLocalDate();

    }

    // 03. java.util.Date --> java.time.LocalTime
    public static void test03() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public static void test04() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public static void test05() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public static void test06() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }
}
