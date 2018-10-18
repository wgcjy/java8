package test;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2017/7/8 0008 0:07
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author:zhouxuan
 * @create:2017-07-08-0:07
 **/
public class MathDemo {
    public static void main(String[] args) {
        /*System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());*/
        /*Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DATE);

        System.out.println(i);
        System.out.println(month);
        System.out.println(day);*/
        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.DAY_OF_MONTH);
        instance.set(Calendar.DAY_OF_MONTH,i-10);
        Date date = instance.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(date));

    }

    public static int compareDate(String str_date1, String str_date2, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date1 = sdf.parse(str_date1);
            Date date2 = sdf.parse(str_date2);
            long time1 = date1.getTime();
            long time2 = date2.getTime();
            if (time1 > time2) {
                return 1;
            } else if (time1 < time2) {
                return -1;
            } else {
                return 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
