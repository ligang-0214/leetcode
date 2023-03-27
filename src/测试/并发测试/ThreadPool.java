package 测试.并发测试;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * @author 松鼠
 * @data 2022/7/6 14:43
 */
public class ThreadPool {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2000));
        for (int i = 0; i < 8000; i++) {
            System.out.println("当前的i:" + i);
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    // 8000不一定是在最后输出  因为你也不知道哪个线程执行的是结果是8000 而且也不能保证这条线程是最后一个执行的
                    System.out.println(atomicInteger.incrementAndGet());
//                    System.out.println("hhhhh");
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}
