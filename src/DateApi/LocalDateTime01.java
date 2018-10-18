package DateApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-21 16:20
 **/
public class LocalDateTime01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
    }
}
