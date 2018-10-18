package java.org.way.exmple.java8;

import java.util.Arrays;

/**
 * Created by way on 2017/12/21.
 */
public class LambdaTesterTwo {

    public static void main(String[] args) {
        //最简单的Lambda表达式可由逗号分隔的参数列表、->符号和语句块组成
        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );
        //在上面这个代码中的参数e的类型是由编译器推理得出的，你也可以显式指定该参数的类型，例如：
        Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
        //如果Lambda表达式需要更复杂的语句块，则可以使用花括号将该语句块括起来，类似于Java中的函数体，例如：
        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
            System.out.print( e );
        } );
        //Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的），例如下列两个代码块的效果完全相同：
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );
        //和
//        final String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );
        //Lambda表达式有返回值，返回值的类型也由编译器推理得出。如果Lambda表达式中的语句块只有一行，则可以不用使用return语句，下列两个代码片段效果相同：
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        //和
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            return result;
        } );

    }
}
