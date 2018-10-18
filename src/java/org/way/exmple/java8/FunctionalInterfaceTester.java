package java.org.way.exmple.java8;

import java.util.function.Supplier;

/**
 * Created by way on 2017/12/21.
 */
public class FunctionalInterfaceTester {

    //<strong>函数接口</strong>
    // 指的是只有一个函数的接口，这样的接口可以隐式转换为Lambda表达式

    //java.lang.Runnable和java.util.concurrent.Callable是函数式接口的最佳例子

    //在实践中，函数式接口非常脆弱：只要某个开发者在该接口中添加一个函数，则该接口就不再是函数式接口进而导致编译失败。为了克服这种代码层面的脆弱性，并显式说明某个接口是函数式接口，Java 8 提供了一个特殊的注解

    //不过有一点需要注意，<strong>默认方法</strong>和<strong>静态方法</strong>不会破坏函数式接口的定义，因此如下的代码是合法的。

    @FunctionalInterface
    public interface Functional {
        void method();
    }

    @FunctionalInterface
    public interface FunctionalDefaultMethods {
        void method();

        //默认方法和抽象方法之间的区别在于抽象方法需要实现，而默认方法不需要。接口提供的默认方法会被接口的实现类继承或者覆写，
        default void defaultMethod() {
        }
    }

    //默认方法---------------
    private interface Defaulable {
        // Interfaces now allow default methods, the implementer may or
        // may not implement (override) them.
        default String notRequired() {
            return "Default implementation";
        }
    }

    private static class DefaultableImpl implements Defaulable {
    }

    private static class OverridableImpl implements Defaulable {
        @Override
        public String notRequired() {
            return "Overridden implementation";
        }
    }

    //静态方法 ----------------
    private interface DefaulableFactory {
        // Interfaces now allow static methods
        static Defaulable create(Supplier<Defaulable> supplier) {
            return supplier.get();
        }
    }

    public static void main( String[] args ) {
        //::方法引用
        Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
        System.out.println( defaulable.notRequired() );

        defaulable = DefaulableFactory.create( OverridableImpl::new );
        System.out.println( defaulable.notRequired() );
    }

}
