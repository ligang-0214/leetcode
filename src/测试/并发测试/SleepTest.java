package 测试.并发测试;

/**
 * @author 松鼠
 * @data 2022/8/22 13:34
 */
public class SleepTest {
    public static void main(String[] args) {
        Object o = new Object();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName() + "获取到锁");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        System.out.println(Thread.currentThread().getName() + "睡醒了");
                    }
                }
            }).start();
        }


    }
}
