package test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import obj.Person;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-09-18 12:58
 **/
public class Test04 {
    public static void main(String[] args) throws Exception {

        //invokedo(100,0);

        //List<String> list = new ArrayList();
        //String s = Optional.ofNullable(list)
        //        .filter(items -> items.size() > 0)
        //        .map(items -> items.get(0))
        //        .orElse("this is null");
        //System.out.println(s);
        List<String> list = new ArrayList();

        list.add("a,b,c,d,e,f,g,g,g,g,g,g,g,g,g");
        list.add("zhangsan,lisi,wangwu,zhaoliu");
        list.add("test,test02,test03,test03");

        list.stream().map(x -> x.split(",")).flatMap(x -> Arrays.stream(x)).distinct().forEach(System.out::println);



    }




    //Person p2= new Person();


    static void invokedo(int a, int b) throws Exception {

        try {
            System.out.println(a / b);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("invoke error");
        } finally {
            System.out.println("this is finally block");
        }
    }
}
