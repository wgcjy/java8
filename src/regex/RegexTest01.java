package regex;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/7 0007 22:36
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:zhouxuan
 * @create:2018-01-07-22:36
 **/
public class RegexTest01 {

    public static void main(String[] args) {
        String a = "1234567";
        //char c = a.charAt(2);
        //String.valueOf(c);
        //System.out.println(c);

        //System.out.println(a.charAt(7));

        /*
        X?       X，一次或一次也没有
        X*       X，零次或多次
        X+       X，一次或多次
        X{n}     X，恰好 n 次
        X{n,}    X，至少 n 次
        X{n,m}   X，至少 n 次，但是不超过 m 次

        . 任何字符（与行结束符可能匹配也可能不匹配）
        \d 数字：[0-9]
        \D 非数字： [^0-9]
        \s 空白字符：[ \t\n\x0B\f\r]
        \S 非空白字符：[^\s]
        \w 单词字符：[a-zA-Z_0-9]
        \W 非单词字符：[^\w]
          */


        //test01();
        test02();

    }

    static void test01() {

        String qq = "35240026011";

        /*
        1、qq号第一位为1-9的数据，所以这里可以直接声明为[1-9]或者写全[123456789]
            非1-9的数字可以写作为[^1-9]或者[^123456789]
        2、目前qq号的长度为5到10位的数字，所以剩下的数字只能出现4到9次 {}是限制某个匹配规则出现的次数的
            所以这里至少出现4次但是不能超过9次
         */
        String regex = "[1-9][0-9]{4,9}";//匹配规则
        System.out.println(qq.matches(regex));
    }

    static void test02() {
        String test = "a123456";
        String regex = "a\\d*";//以a打头,后面跟的为数字出现0次或者多次
        //String regex = "[^b]\\d*";//也可以写成以非b打头后面出现的数字0次或多次,不能写为"^b\\d*",必须要用中括号
        //通常第一位为一个确定的值是可以直接写a或者[a]

        //以下为三种判断匹配的方法
        System.out.println(test.matches(regex));

        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(test);
        boolean matches = matcher.matches();
        System.out.println(matches);

        System.out.println(Pattern.matches(regex, test));
    }
}
