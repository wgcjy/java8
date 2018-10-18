package DateApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-21 16:20
 **/
public class LocalDateTime02 {
    public static void main(String[] args) {

        test01();
    }

    public static void test01(){
        LocalDate nowDate = LocalDate.of(2017, 8, 28);
        LocalTime nowTime = LocalTime.of(0, 0, 0);
        LocalDateTime localDateTime = nowDate.atTime(nowTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        LocalDateTime localDateTime1 = localDateTime.minusDays(1);
        System.out.println(localDateTime1);

    }
}
