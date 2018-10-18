package DateApi;

import java.time.LocalDate;
import java.time.Period;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-21 14:35
 **/
public class LocalDate03 {

    public static void main(String[] args) {
        //Format examples
        LocalDate date = LocalDate.now();

        LocalDate beforeDay = LocalDate.of(2017, 7, 20);
        Period between = Period.between(beforeDay, date);
        System.out.println("相差天数:" + between.getDays());
        System.out.println("================");
        System.out.println(Math.abs(between.getDays()));

    }

}
