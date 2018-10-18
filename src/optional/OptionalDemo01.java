package optional;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2017/8/18 0018 23:13
 */

import obj.Person;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @Author:zhouxuan
 * @create:2017-08-18-23:13
 **/
public class OptionalDemo01 {
    public static void main(String[] args) {
        //test02();
        //test03();
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);

    }

    public static void test01() {
        String name = null;
        Optional<String> optName = Optional.ofNullable(name);
        //传入一个consumer,没有返回值
        optName.ifPresent(p -> {
            System.out.println(p);
        });
    }

    public static void test02() {
        String name = "abc";
        //String name = null;
        Optional<String> optName = Optional.ofNullable(name);
        /*String s = optName.map(String::toUpperCase)
                .orElseGet(() -> {
                    String a = "this is null";
                    return a;
                });*/
        String s = optName.orElseGet(() -> {
            String a = "this is null";
            return a;
        });
        System.out.println(s);
    }

    public static void test03() {
        //Person person = null;
        Person person = new Person(10001, "张三", "1", "123456", 15, new BigDecimal("1000.24"));
        Optional<Person> optPerson = Optional.ofNullable(person);
        /*String s = optPerson.filter(person1 -> person1.getAge() > 20)
                .map(Person::getUserName)
                .orElseGet(() -> "this is null");*/

        /*Person person2 = optPerson.filter(person1 -> person1.getAge() > 20)
                .orElseGet(() -> new Person());
        System.out.println(person2.toString());*/

        optPerson.filter(person1 -> person1.getAge()>20)
                .ifPresent(person1 -> {
                    System.out.println(person1);
                });
    }
}
