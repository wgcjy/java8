package thread;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/2 0002 0:18
 */

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author:zhouxuan
 * @create:2018-01-02-0:18
 **/
public class BasicFuture {

    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end to compute,passed " + (System.currentTimeMillis() - t));
        return rand.nextInt(1000);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(BasicFuture::getMoreData);
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });
        System.out.println(f.get());
    }
}
