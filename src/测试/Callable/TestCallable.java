package 测试.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Author:松鼠
 * Date:2021/5/16 15:05
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 10; i++) {
            Callable c = new CallableImpl(i + " ");
            // 执行任务并获取 Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();  // 关闭线程池

        for (Future f : list) {
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("res：" + f.get().toString());
        }
    }
}
