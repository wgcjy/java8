package DateApi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-21 14:35
 **/
public class LocalDate02 {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        //判断闰年
        //System.out.println(today.getYear()+" 是否是闰年? "+today.isLeapYear());

        //比较时间先后
        //System.out.println("今天是否在2015/01/01之前? "+today.isBefore(LocalDate.of(2015,1,1)));

        //结合此日期与时间创建一个 LocalDateTime
        System.out.println("Current Time="+today.atTime(LocalTime.now()));

        //日期偏移量操作 operations
        //today.plus(10, ChronoUnit.DAYS);
        System.out.println("10天之后"+today.plusDays(10));

        //today.plus(3,ChronoUnit.WEEKS);
        System.out.println("3个星期之后"+today.plusWeeks(3));

        //today.plus(20,ChronoUnit.MONTHS);
        System.out.println("20个月份之后"+today.plusMonths(20));

        //today.minus(10,ChronoUnit.DAYS);
        System.out.println("10天之前"+today.minusDays(10));
        //today.minus(3,ChronoUnit.WEEKS);
        System.out.println("3个星期之前"+today.minusWeeks(3));
        //today.minus(20,ChronoUnit.MONTHS);
        System.out.println("20个月之前"+today.minusMonths(20));

        //返回此日期的调整副本
        System.out.println("当前月份的第一天:"+today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("当前月份的最后一天："+ today.with(TemporalAdjusters.lastDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("今年的最后一天"+lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format= "+period);
        System.out.println("Months remaining in the year= "+period.getMonths());
        System.out.println("days remaining in the year= "+period.getDays());


    }

}
