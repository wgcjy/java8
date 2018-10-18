package stream;

import obj.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Admin on 2017/8/18 0018.
 */
public class StreamDemo03 {

    public static void main(String[] args) {
        String userStr = "";
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        userStr = list.stream().collect(Collectors.joining(","));
        System.out.println(userStr);
    }

    public void test01() {
        List<Person> userList = Arrays.asList(
                new Person(10001, "张三", "1", "123456", 15, new BigDecimal("1000.24")),
                new Person(10002, "李四", "2", "mypassword", 19, new BigDecimal("990.54")),
                new Person(10003, "王五", "1", "19920202zx", 28, new BigDecimal("1060.64")),
                new Person(10004, "赵六", "1", "test0100", 37, new BigDecimal("144.55")),
                new Person(10005, "陈七", "2", "this100211", 55, new BigDecimal("108.83"))
        );

        /*Collections.sort(userList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });*/

        /*userList.stream()
                .filter(person -> person.getAge() > 18)
                .sorted(Comparator.comparing(Person::getAge))
                .map(person -> person.getAge())
                .forEach(System.out::println);

        long count = userList.stream()
                .filter(person -> person.getAge() > 18)
                .mapToInt(Person::getUserId)
                .count();
        System.out.println(count);

        int sum = userList.stream()
                .filter(person -> person.getAge() > 18)
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sum);

        BigDecimal salcount = userList.stream()
                .filter(person -> person.getAge() > 18)
                .map(Person::getSal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(salcount);*/

        //groupingBy
        Map<String, List<Person>> collect = userList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(collect);
    }

}
