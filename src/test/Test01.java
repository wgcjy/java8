package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/7/26 0026.
 */


public class Test01 {
    public static void main(String[] args) {
        LocalDate nowdate = LocalDate.now();
        System.out.println(nowdate.toString());

        LocalTime nowtime = LocalTime.now();
        System.out.println(nowtime.toString());

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.toString());



    }
}
