package DateApi;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-21 14:35
 **/
public class LocalDate01 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        /*int year = date.getYear();
        System.out.println(year);
        Month month = date.getMonth();
        System.out.println(month);
        int dayOfMonth = date.getDayOfMonth();
        System.out.println(dayOfMonth);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);
        int i = date.lengthOfMonth();
        System.out.println(i);
        boolean leapYear = date.isLeapYear();
        System.out.println(leapYear);*/

        /*int i = date.get(ChronoField.YEAR);
        System.out.println(i);
        int i1 = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(i1);
        int i2 = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(i2);*/

        /*LocalDate now = LocalDate.now();
        String yyyyMMdd = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(yyyyMMdd);*/

        //Current Date
        LocalDate today = LocalDate.now();
        String format = today.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("Current Date=" + format);

        //Creating LocalDate by providing input arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date=" + firstDay_2014);

        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException:
        //Invalid date 'February 29' as '2014' is not a leap year

        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST=" + todayKolkata);

        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

        //Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date= " + dateFromBase);

        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014=" + hundredDay2014);


    }

}
