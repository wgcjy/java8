package thread;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/1 0001 23:46
 */

import java.util.concurrent.CompletableFuture;

/**
 * @Author:zhouxuan
 * @create:2018-01-01-23:46
 **/
public class CallableAndFuture2 {

    public static void main(String[] args) {
        try {
            final CompletableFuture future = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello world";
            });
            System.out.println("test");
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
