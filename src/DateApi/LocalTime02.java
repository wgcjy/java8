package DateApi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-21 16:13
 **/
public class LocalTime02 {
    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        //test04();
        test05();
        //test06();

    }

    private static void test01() {
        //指定特定的日期(例如生日)
        LocalDate dateOfBirth = LocalDate.of(1992, 8, 22);
        MonthDay birthDay = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentDay = MonthDay.from(LocalDate.now());
        if (birthDay.equals(currentDay)) {
            System.out.println("today is your birthday");
        } else {
            System.out.println("today is not your birthday");
        }
    }

    private static void test02() {
        String date = "20170822";
        //LocalDate parsedate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parsedate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(parsedate);

    }

    private static void test03() {
        /*Date date = new Date();
        long time = date.getTime();
        System.out.println(time);*/


        //java8中获取时间戳
        Instant now = Instant.now();
        Date fromDate = Date.from(now);
        System.out.println(fromDate);

    }

    //计算两个日期相差多少 year,month,day
    private static void test04() {
        LocalDate today = LocalDate.now();
        System.out.println("Today : " + today);
        LocalDate birthDate = LocalDate.of(1993, Month.AUGUST, 22);
        System.out.println("BirthDate : " + birthDate);

        Period p = Period.between(birthDate, today);
        System.out.printf("年龄 : %d 年 %d 月 %d 日", p.getYears(), p.getMonths(), p.getDays());
    }

    //计算两个日期
    private static void test05() {
        /*LocalDate startDate = LocalDate.of(2017,8,20);
        LocalTime startTime = LocalTime.of(12,10,10);
        LocalDateTime startLocalDateTime = startDate.atTime(startTime);

        LocalDate endDate = LocalDate.now();
        LocalTime endTime = LocalTime.of(12,10,10);
        LocalDateTime endLocalDateTime = endDate.atTime(endTime);*/

        String startDateTime = "20170820111012";
        String endDateTime = "20170822121010";
        LocalDateTime startLocalDateTime = LocalDateTime.parse(startDateTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime endLocalDateTime = LocalDateTime.parse(endDateTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        long between = ChronoUnit.HOURS.between(startLocalDateTime, endLocalDateTime);
        System.out.println(between);
    }

    //两个日期相差天数
    private static void test06() {

        LocalDate startDate = LocalDate.of(2016, 8, 22);
        LocalDate endDate = LocalDate.now();

        long between = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println(between);
    }
}
