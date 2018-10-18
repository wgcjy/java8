package DateApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-21 16:13
 **/
public class WarningDays {
    public static void main(String[] args) {
        //LocalDate now = LocalDate.now();
        //LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
        //LocalDate today = firstDay.plusDays(-1);
        ////cal.set(Calendar.DAY_OF_MONTH, 1 - param + warningDays);//设置为1号,当前日期既为本月第一天
        //String lessPaperDrewDate = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        //System.out.println(lessPaperDrewDate);

        String paperDrewDate1 = "20170616";
        Integer warningDays = 350;
        //底账预警
        System.out.println("=====================开票日期7月1号之前的=============================");
        getTest1(paperDrewDate1,warningDays);
        //isBelongElWarningDate(paperDrewDate,warningDays);
        //传统预警
        getTest2(paperDrewDate1, warningDays);
        //isBelongAuthWarningDate(paperDrewDate, warningDays);


        System.out.println("=====================开票日期7月1号之后的=============================");
        String paperDrewDate2 = "20170716";
        getTest1(paperDrewDate2,warningDays);
        getTest2(paperDrewDate2,warningDays);
    }

    //底账预警天数
    public static void getTest1(String str_paperDrewDate, Integer warningDays) {

        try {
            //System.out.println("开票日期:" + str_paperDrewDate + " 预警天数:" + warningDays);
            System.out.println("预警天数:" + warningDays);
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date paperDrewDate = format.parse(str_paperDrewDate);
            Date compareDate = format.parse("20170701");
            int before = compareDate(paperDrewDate, compareDate);
            //开票日期在20170701之前,按180天计算
            Integer param = (-1 == before) ? 180 : 360;
            LocalDate now = LocalDate.now();
            LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());//当前月第一天
            LocalDate startDateLocal = firstDay.plusDays(-param);
            LocalDate endDateLocal = firstDay.plusDays(-param + warningDays);

            ZoneId zone = ZoneId.systemDefault();
            Instant startInstant = startDateLocal.atStartOfDay().atZone(zone).toInstant();
            Date startDate = Date.from(startInstant);
            //System.out.println(format.format(startDate));
            Instant endInstant = endDateLocal.atStartOfDay().atZone(zone).toInstant();
            Date endDate = Date.from(endInstant);
            System.out.println("底账预警区间:" + format.format(startDate) + "-----" + format.format(endDate));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //传统预警天数
    public static void getTest2(String str_paperDrewDate, Integer warningDays) {

        try {
            //System.out.println("开票日期:" + str_paperDrewDate + " 预警天数:" + warningDays);
            System.out.println("预警天数:" + warningDays);
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date paperDrewDate = format.parse(str_paperDrewDate);
            Date compareDate = format.parse("20170701");
            int before = compareDate(paperDrewDate, compareDate);
            //开票日期在20170701之前,按180天计算
            Integer param = (-1 == before) ? 180 : 360;
            LocalDate now = LocalDate.now();
            //LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());//当前月第一天
            LocalDate startDateLocal = now.plusDays(-param);
            LocalDate endDateLocal = now.plusDays(-param + warningDays);

            ZoneId zone = ZoneId.systemDefault();
            Instant startInstant = startDateLocal.atStartOfDay().atZone(zone).toInstant();
            Date startDate = Date.from(startInstant);
            //System.out.println(format.format(startDate));
            Instant endInstant = endDateLocal.atStartOfDay().atZone(zone).toInstant();
            Date endDate = Date.from(endInstant);
            System.out.println("传统预警区间:" + format.format(startDate) + "-----" + format.format(endDate));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static int compareDate(Date date1, Date date2) {
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        if (time1 > time2) {
            return 1;
        } else if (time1 < time2) {
            return -1;
        } else {
            return 0;
        }
    }


    public static String isBelongElWarningDate(String str_paperDrewDate, int warningDays) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            Date paperDrewDate = format.parse(str_paperDrewDate);
            Date compareDate = format.parse("20170701");
            int before = compareDate(paperDrewDate, compareDate);
            //开票日期在20170701之前,按180天计算
            Integer param = (-1 == before) ? 180 : 360;
            Calendar cal_1 = Calendar.getInstance();//获取当前日期
            cal_1.set(Calendar.DAY_OF_MONTH, 1 - param + warningDays);//设置为1号,当前日期既为本月第一天
            Date minPaperDrewDate = cal_1.getTime();

            Calendar cal_2 = Calendar.getInstance();//获取当前日期
            cal_2.set(Calendar.DAY_OF_MONTH, 1 - param);//设置为1号,当前日期既为本月第一天
            Date maxPaperDrewDate = cal_2.getTime();
            System.out.println("底账预警区间:" + format.format(maxPaperDrewDate) + "-----" + format.format(minPaperDrewDate));

            //int minValue = compareDate(minPaperDrewDate, paperDrewDate);
            //int maxValue = compareDate(paperDrewDate, maxPaperDrewDate);
            //maxPaperDrewDate < paperDrewDate <= minPaperDrewDate
            //return (minValue >= 0 && maxValue > 0) ? "1" : "0";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String isBelongAuthWarningDate(String str_paperDrewDate, int warningDays) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            Date paperDrewDate = format.parse(str_paperDrewDate);
            Date compareDate = format.parse("20170701");
            int before = compareDate(paperDrewDate, compareDate);
            //开票日期在20170701之前,按180天计算
            Integer param = (-1 == before) ? 180 : 360;
            Calendar cal_1 = Calendar.getInstance();//获取当前日期
            int i = cal_1.get(Calendar.DAY_OF_MONTH);
            cal_1.set(Calendar.DAY_OF_MONTH, i - param + warningDays);
            Date minPaperDrewDate = cal_1.getTime();

            Calendar cal_2 = Calendar.getInstance();//获取当前日期
            int j = cal_2.get(Calendar.DAY_OF_MONTH);
            cal_2.set(Calendar.DAY_OF_MONTH, j - param);
            Date maxPaperDrewDate = cal_2.getTime();
            System.out.println("传统预警区间:" + format.format(maxPaperDrewDate) + "-----" + format.format(minPaperDrewDate));

            int minValue = compareDate(minPaperDrewDate, paperDrewDate);
            int maxValue = compareDate(paperDrewDate, maxPaperDrewDate);
            //maxPaperDrewDate < paperDrewDate <= minPaperDrewDate
            return (minValue >= 0 && maxValue > 0) ? "1" : "0";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";

    }


}
