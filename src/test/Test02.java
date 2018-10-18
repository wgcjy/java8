package test;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/7/26 0026.
 */


public class Test02 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());

        LocalDate localDate = lastDay.minusDays(16);
        System.out.println(localDate);
        System.out.println(today.equals(localDate));


    }


}
