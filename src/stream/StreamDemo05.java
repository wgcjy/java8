package stream;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2017/8/18 0018 20:36
 */

import obj.Person;

import java.math.BigDecimal;
import java.nio.channels.NonWritableChannelException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:zhouxuan
 * @create:2017-08-18-20:36
 **/
public class StreamDemo05 {
    public static void main(String[] args) {
        StreamDemo05 streamDemo01 = new StreamDemo05();
//        streamDemo01.test01();
        streamDemo01.test02();
    }

    //jdk1.8之前
    public void test01() {
        List<Person> userList = Arrays.asList(
                new Person(0001, "张三", "password01","1", 22, new BigDecimal("1100.12")),
                new Person(0002, "李四", "123456","1", 12, new BigDecimal("1000.28")),
                new Person(0003, "王五", "mybirthday","2", 20, new BigDecimal("58.66")),
                new Person(0004, "赵六", "my19920323","2", 18, new BigDecimal("79.65")),
                new Person(0005, "陈七", "test123","2", 19, new BigDecimal("579.11"))
        );
        //获取年龄大于18的用户
        List<Person> list1 = new ArrayList<Person>();
        for (Person person : userList) {
            if (person.getAge() > 18) {
                list1.add(person);
            }
        }
        //按照年龄进项排序
        Collections.sort(list1, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
//        System.out.println(list1);
        //处理排序完后的集合
        List<String> list2 = new ArrayList<String>();
        for (Person person : list1) {

            list2.add(person.getUserName());
        }
        System.out.println(list2);

    }

    public void test02() {
        List<Person> userList = Arrays.asList(
                new Person(0001, "张三", "password01","1", 22, new BigDecimal("1100.12")),
                new Person(0002, "李四", "123456","1", 12, new BigDecimal("1000.28")),
                new Person(0003, "王五", "mybirthday","2", 20, new BigDecimal("58.66")),
                new Person(0004, "赵六", "my19920323","2", 18, new BigDecimal("79.65")),
                new Person(0005, "陈七", "test123","2", 19, new BigDecimal("579.11"))
        );

        /*List<String> list1 = userList.stream().filter(person -> person.getAge() > 18).map(person -> person.getUserName()).collect(toList());
        System.out.println(list1);*/

        userList.stream()
                .filter(person -> dovalidate(person))
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getSal).reversed())
                .peek(person -> {
                    System.out.println(person.getAge());
                })
                .map(Person::getUserName)
                .forEach(person -> {
                    System.out.println("person = " + person);
                });
//                .collect(toList());
//        System.out.println(list2);
        userList.stream().forEach(person -> {
            System.out.println("person =sss " + person.getUserName());
        });
    }

    public boolean dovalidate(Person person) {
        boolean flag = false;
        if (person.getAge() > 18)
            flag = true;
        return flag;
    }

    public void test03() {
        List<Person> userList = Arrays.asList(
                new Person(0001, "张三", "password01","1", 22, new BigDecimal("1100.12")),
                new Person(0002, "李四", "123456","1", 12, new BigDecimal("1000.28")),
                new Person(0003, "王五", "mybirthday","2", 20, new BigDecimal("58.66")),
                new Person(0004, "赵六", "my19920323","2", 18, new BigDecimal("79.65")),
                new Person(0005, "陈七", "test123","2", 19, new BigDecimal("579.11"))
        );

        //规约操作
        /*BigDecimal reduce = userList.stream()
                .map(Person::getSal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);*/
        /*BigDecimal collect = userList.stream().collect(Collectors.reducing(BigDecimal.ZERO, Person::getSal, BigDecimal::add));
        System.out.println(collect);*/

        //grouingBy
        /*Map<String, List<Person>> collect = userList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(collect);*/

        //求薪水最高的人 maxBy
        //Optional<Person> collect1 = userList.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getSal)));
        /*collect1.ifPresent(person -> {
            System.out.println(person);
        });*/
        /*Person person = collect1.orElseGet(() -> {
            return null;
        });
        System.out.println(person);*/

        //求男性、女性各自薪水总和
        Map<String, BigDecimal> collect = userList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.reducing(BigDecimal.ZERO, Person::getSal, BigDecimal::add)));
        System.out.println(collect);

        //求男性、女性中各自薪水最高的那个人
        Map<String, Optional<Person>> collect1 = userList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.maxBy(Comparator.comparing(Person::getSal))));
        System.out.println(collect1);
        //上面的例子带optional
        Map<String, Person> collect3 = userList.stream()
                .collect(Collectors.groupingBy(Person::getSex,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Person::getSal))
                                , Optional::get)));

        //多级分组
        Map<String, Map<String, List<Person>>> collect2 = userList.stream().collect(Collectors.groupingBy(Person::getSex,
                Collectors.groupingBy(p -> {
                    if (new BigDecimal("1000").compareTo(p.getSal()) < 0) {
                        return "a";
                    } else if (new BigDecimal("500").compareTo(p.getSal()) < 0) {
                        return "b";
                    } else {
                        return "c";
                    }
                })));
        System.out.println(collect2);

    }


}