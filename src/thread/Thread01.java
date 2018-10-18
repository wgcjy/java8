package thread;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2017/11/15 0015 21:25
 */

/**
 * @Author:zhouxuan
 * @create:2017-11-15-21:25
 **/
public class Thread01 {
    public static void main(String[] args) {
        Thread thread = new Thread();
    }
}

class Runnable1 implements Runnable{
    @Override
    public void run() {
        System.out.println();
    }
}
