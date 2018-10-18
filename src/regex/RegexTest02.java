package regex;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/7 0007 23:38
 */

import java.util.regex.Pattern;

/**
 * @Author:zhouxuan
 * @create:2018-01-07-23:38
 **/
public class RegexTest02 {

    public static void main(String[] args) {
        //test01();
        test02();
    }


    /**
     * 匹配
     */
    private static void test01() {
        //校验手机号
        String tel = "13621140608";
        String regex = "1[35678]\\d{9}";//13 15 16 17 18开头的号码 或者写成 "1[35678][0-9]{9}"
        System.out.println(Pattern.matches(regex, tel));
    }

    /**
     * 切割
     */
    private static void test02() {

        String names_str = "zhangsan lisi  wangwu  zhaoliu";
        String[] split = names_str.split(" +");
        /*for (String s : split) {
            System.out.println(s);
        }*/

        //String names_str2 = "zhangsan||lisi||wangwu||zhaoliu";
        //String[] split2 = names_str2.split("\\|{2}");


        //String names_str2 = "zhangsan\\lisi\\wangwu\\zhaoliu";
        //System.out.println(names_str2);
        //String[] split2 = names_str2.split("\\\\");


        String names_str2 = "zhangsanaaaaalisibbbbwangwuccczhaoliu";
        System.out.println(names_str2);
        String[] split2 = names_str2.split("(.)\\1+");

        for (String s : split2) {
            System.out.println(s);
        }

    }

}
