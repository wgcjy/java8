package optional;

import java.util.Optional;

/**
 * @Author:zhouxuan
 * @create:2017-08-18-23:13
 **/
public class OptionalDemo02 {
    public static void main(String[] args) {


        //orElse有返回值
        /*Optional<String> name = Optional.ofNullable("zhangsan");
        Optional empty = Optional.ofNullable(null);
        String n = name.orElse("name is null");
        System.out.println(n);

        Object o = empty.orElse("empty is null");
        System.out.println(o.toString());*/

        //orElseGet又返回值
        /*Optional<String> name = Optional.ofNullable(null);
        String s = name.orElseGet(() -> {
            String abc = "aaaa";
            String[] split = abc.split("");
            String collect = Arrays.asList(split).stream().collect(Collectors.joining("|"));
            return collect;
        });
        System.out.println(s);*/

        //orElseThrow
        /*Optional<String> name = Optional.ofNullable(null);
        String s = name.orElseThrow(NullPointerException::new);
        System.out.println(s);*/

        //map
        /*String name = null;
        String aaa = Optional.ofNullable(name).map(String::toUpperCase).orElseGet(() -> "error");
        System.out.println(aaa);*/

        //ifPresent
        String name = null;
        Optional.ofNullable(name).ifPresent(System.out::println);
    }
}
