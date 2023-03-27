package 测试.Synchronized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 松鼠
 * @data 2022/7/20 10:01
 */
public class WaitTest {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + "输出");
                    try {
                        o.wait();
//                        o.wait(500);
//                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();


        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            boolean b = lock.tryLock();
            if (b) {
                System.out.println("获取成功");
            } else {
                System.out.println("获取失败");
            }
        }).start();


//        new Thread(() -> {
//            while (true) {
//                synchronized (o) {
//                    System.out.println(Thread.currentThread().getName() + "输出");
//                    try {
//                        o.wait(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        Thread.sleep(5000);


    }

}
