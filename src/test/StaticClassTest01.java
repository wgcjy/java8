package test;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-09-11 13:32
 **/
public class StaticClassTest01 {
    private String outname01;
    private static String outname02;


    /**
     * 如果一个内部类不是被定义成静态内部类，
     * 那么在定义成员变量或者成员方法的时候，是不能够被定义成静态成员变量与静态成员方法的。
     * 也就是说，在非静态内部类中不可以声明静态成员
     */
    //编译通过
    private static class StaticClass01 {

        public String name;
        public String age;
        public static String sex;

        String myname01 = outname02;
        //String myname02 = outname01;编译不通过
    }

    /*
    编译不过
     */
    private class Class01 {
        //在非静态内部类中定义静态成员变量和方法编译不通过
        //public static String username;
        /*public static String getInfo (){
          return "this is innermethod";
        }*/

        //定义非静态的可以编译通过
        //public String username;

        String my = outname01;
        String name02 = outname02;
    }

    public static void main(String[] args) {
        StaticClassTest01 staticClassTest01 = new StaticClassTest01();
        //实例化非静态内部类
        Class01 class01 = staticClassTest01.new Class01();

        //实例化静态内部类
        StaticClass01 staticClass01 = new StaticClass01();
    }
}
