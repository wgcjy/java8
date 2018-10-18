package java.org.way.exmple.java8;

/**
 * Created by way on 2017/12/21.
 */
public class LambdaTesterOne {

    /**
     * Lambda expressions are used primarily to define inline implementation of a functional interface, i.e., an interface with a single method only.
     * In the above example, we've used various types of lambda expressions to define the operation method of MathOperation interface.
     * Then we have defined the implementation of sayMessage of GreetingService.
     * <p>
     * Lambda expression eliminates the need of anonymous class and gives a very simple yet powerful functional programming capability to Java.
     *
     * @param args
     */

    public static void main(String args[]) {
        LambdaTesterOne tester = new LambdaTesterOne();

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces 有大括号
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        //without return statement and without curly braces 没有大括号
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //without parenthesis 插入语, 附带, 附带物
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //with parenthesis 插入语, 附带, 附带物
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
