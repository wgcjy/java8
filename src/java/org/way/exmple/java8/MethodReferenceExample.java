package java.org.way.exmple.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by way on 2017/12/21.
 */
public class MethodReferenceExample {
    public static void main(String args[]) {
        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);
    }
}
