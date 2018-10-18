package enumTest;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/15 0015 22:53
 */

/**
 * @Author:zhouxuan
 * @create:2018-01-15-22:53
 **/
public class TestEnum01 {
    public static void main(String[] args) {
        //Enum02 spring = Enum02.valueOf("SPRING1");
        //System.out.println(spring.getSeasonDesc());

        System.out.println(Enum02.SPRING.getSeasonName() + Enum02.SPRING.getSeasonDesc());

    }
}
