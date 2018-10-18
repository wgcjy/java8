package thread;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/1 0001 22:15
 */

import java.util.concurrent.*;

/**
 * @Author:zhouxuan
 * @create:2018-01-01-22:15
 **/
public class CallableAndFuture {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            //1、直接使用callable
            //
            //Future<String> future = executorService.submit(() -> {
            //    Thread.sleep(3000);
            //    return "hello world";
            //});
            //System.out.println("等待数据返回");
            //System.out.println("拿到结果:" + future.get());


            //使用futuretask
            FutureTask<String> futureTask = new FutureTask<>(() -> {
                Thread.sleep(5000);
                return "hello world";
            });
            executorService.submit(futureTask);
            String s = futureTask.get();
            System.out.println("拿到结果:" + s);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
