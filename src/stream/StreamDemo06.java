package stream;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2017/8/18 0018 20:36
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:zhouxuan
 * @create:2017-08-18-20:36
 **/
public class StreamDemo06 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("jkl");


        Predicate<String> j = n -> n.startsWith("j");
        list.stream().filter(j).forEach(System.out::println);

        Consumer<String> stringConsumer = (String x) -> Arrays.stream(x.split(","));


    }

}