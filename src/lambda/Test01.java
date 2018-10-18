package lambda;

import obj.Person;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-25 10:54
 **/
public class Test01 {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        List<Person> userList = Arrays.asList(
                new Person(10001, "张三", "1", "123456", 15, new BigDecimal("1000.24")),
                new Person(10002, "李四", "2", "mypassword", 44, new BigDecimal("990.54")),
                new Person(10003, "王五", "1", "19920202zx", 28, new BigDecimal("1060.64")),
                new Person(10004, "赵六", "1", "test0100", 66, new BigDecimal("144.55")),
                new Person(10005, "陈七", "2", "this100211", 55, new BigDecimal("108.83"))
        );

        Collections.sort(userList, (o1, o2) -> o1.getAge().compareTo(o2.getAge()));

        /*Collections.sort(userList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });*/
        System.out.println(userList);

        /*String collect = userList.stream().sorted(Comparator.comparing(Person::getAge)).map(Person::getUserName).collect(Collectors.joining(","));
        System.out.println(collect);*/


    }
}
