package java.org.way.exmple.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by way on 2017/12/21.
 */
public class MethodReferenceExample2 {

    public static class Car {
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }

    public static void main(String[] args) {
        //第一种方法引用的类型是构造器引用，语法是Class::new，或者更一般的形式：Class<T>::new。注意：这个构造器没有参数。
        /*Supplier<Car> carSupplier = new Supplier<Car>() {
            @Override
            public Car get() {
                return new Car();
            }
        };*/
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        //第二种方法引用的类型是静态方法引用，语法是Class::static_method。注意：这个方法接受一个Car类型的参数。
        cars.forEach(Car::collide);

        //第三种方法引用的类型是某个类的成员方法的引用，语法是Class::method，注意，这个方法没有定义入参：
        cars.forEach(Car::repair);

        //第四种方法引用的类型是某个实例对象的成员方法的引用，语法是instance::method。注意：这个方法接受一个Car类型的参数：
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

        //运行上述例子，可以在控制台看到如下输出（Car实例可能不同）：
    }

}
