package test;

import sun.java2d.SurfaceDataProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        String aa = "获取结果失败[未收到过任务号为77a84de7-5266-4d7a-bf06-0" +
                "3feb27bac77的请求，请确认任务号是否正确！] URL:http://114.55.59.127:8090/" +
                "invoice/verify/download?taskId=77a84de7-5266-4d7a-bf06-03feb27bac77";

        System.out.println(aa.length());
    }



    public static int compareDate(String str_date1, String str_date2, String pattern){
        Integer result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date1 = sdf.parse(str_date1);
            Date date2 = sdf.parse(str_date2);
            long time1 = date1.getTime();
            long time2 = date2.getTime();
            if (time1 > time2) {
                result = 1;
            } else if (time1 < time2) {
                result = -1;
            } else {
                result = 0;
            }
        } catch (Exception e) {
            result = 500;
        }
        return result;

    }

    /**
     * 获取近months月中最小的一天和最大的一天
     * @param months
     * @return
     */
    public static Map getMonthDay(String months) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date now = new Date();
        String nowMonth = sdf.format(now);

        Date date = null;
        try {
            date = sdf.parse(nowMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);

        rightNow.set(Calendar.DATE, rightNow.getActualMaximum(Calendar.DATE));
        rightNow.add(Calendar.MONTH, -1);
        Date lastDayTime = rightNow.getTime();
        String lastDay = sdf.format(lastDayTime);

        rightNow.add(Calendar.MONTH, -((Integer.parseInt(months) - 1)));
        rightNow.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayTime = rightNow.getTime();
        String firstDay = sdf.format(firstDayTime);

        Map map = new HashMap();
        map.put("firstDay", firstDay);
        map.put("lastDay", lastDay);

        return map;
    }

}