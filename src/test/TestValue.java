package test;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-09-15 10:21
 **/
public class TestValue {
    public static void main(String[] args) {


        try {
            //new valu
            int a = 100;
            int b = 0;
            int c = a / b;
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("======================");
            System.out.println(e.getMessage());

            e.printStackTrace();

            System.out.println(e.toString());

        }
    }
}
