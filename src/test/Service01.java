package test;

/**
 * @Description: TODO
 * @Author: zhouxuan
 * @Date: 2018/1/18 0018 16:02
 */
@FunctionalInterface
public interface Service01 {

    String add(String string);
    default String add2(String string) {
        return "";
    };
}
