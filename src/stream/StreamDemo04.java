package stream;

import obj.Person;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Admin on 2017/8/18 0018.
 */
public class StreamDemo04 {

    public static void main(String[] args) {

        test01();
    }

    public static void test01() {
        List<Map<String,String>> list = new ArrayList<>();

        Map<String,String> map1 = new HashMap();
        map1.put("pid","10001");

        Map<String,String> map2 = new HashMap();
        map2.put("pid","10003");

        Map<String,String> map3 = new HashMap();
        map2.put("pid","10005");

        list.add(map1);
        list.add(map2);
        list.add(map3);


        List<Person> userList = Arrays.asList(
                new Person(10001, "张三", "1", "123456", 15, new BigDecimal("1000.24")),
                new Person(10002, "李四", "2", "mypassword", 19, new BigDecimal("990.54")),
                new Person(10003, "王五", "1", "19920202zx", 28, new BigDecimal("1060.64")),
                new Person(10004, "赵六", "1", "test0100", 37, new BigDecimal("144.55")),
                new Person(10005, "陈七", "2", "this100211", 55, new BigDecimal("108.83"))
        );


        List<String[]> pid1 = list.stream()
                .map(item -> item.get("pid"))
                .filter(pid -> "10001".equals(pid))
                .map(pid -> {
                    final String[] userName = {""};
                    userList.stream().filter(person -> person.getUserId().toString().equals(pid)).findFirst().ifPresent(person -> {
                        userName[0] = person.getUserName();
                        System.out.println(person.getUserName());
                    });
                    return userName;
                }).collect(Collectors.toList());

        System.out.println(pid1.toString());

    }

}
