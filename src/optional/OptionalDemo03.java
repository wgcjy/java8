package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author:zhouxuan
 * @create:2017-08-18-23:13
 **/
public class OptionalDemo03 {
    public static void main(String[] args) {

        List<String> list = null;
        /*list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Optional.ofNullable(list).ifPresent(items -> {
            items.forEach(System.out::println);
            String collect = items.stream().collect(Collectors.joining(","));
            System.out.println(collect);
        });*/

        String collect = list.stream().collect(Collectors.joining());
    }
}
