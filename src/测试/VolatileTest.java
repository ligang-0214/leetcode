package 测试;

/**
 * Author:松鼠
 * Date:2021/9/6 16:08
 */
public class VolatileTest {
    public static  volatile int race = 0;
    public static void increase() {
        race++;
    }
    private static final int THREADS_COUNT = 10;


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        long star = System.currentTimeMillis();
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 6000; i++) {
                        increase();
                    }}
            });
            threads[i].start();
        }
        // 等待所有累加线程都结束
//        while (Thread.activeCount() > 1)
//            Thread.sleep(2000);
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println(race + "耗时："+ (end-star));
    }
}
