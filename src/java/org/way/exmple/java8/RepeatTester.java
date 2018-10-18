package java.org.way.exmple.java8;

import java.lang.annotation.*;

/**
 * Created by way on 2017/12/21.
 */
//在同一个地方不能多次使用同一个注解。Java 8打破了这个限制
    //正如我们所见，这里的Filter类使用@Repeatable(Filters.class)注解修饰，而Filters是存放Filter注解的容器，编译器尽量对开发者屏蔽这些细节。这样，Filterable接口可以用两个Filter注解注释（这里并没有提到任何关于Filters的信息）。

//另外，反射API提供了一个新的方法：getAnnotationsByType()，可以返回某个类型的重复注解，例如Filterable.class.getAnnoation(Filters.class)将返回两个Filter实例，输出到控制台的内容如下所示：

public class RepeatTester {
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };

    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {
    }

    public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }

}
