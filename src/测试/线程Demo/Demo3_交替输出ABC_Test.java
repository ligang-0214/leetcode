package 测试.线程Demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 松鼠
 * @data 2022/4/4 15:05
 */
public class Demo3_交替输出ABC_Test {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        PrintABC conditionThreadA = new PrintABC(lock, condition, "A");
        PrintABC conditionThreadB = new PrintABC(lock, condition, "B");
        PrintABC conditionThreadC = new PrintABC(lock, condition, "C");
        new Thread(conditionThreadA, "Thread-A").start();
        new Thread(conditionThreadB, "Thread-B").start();
        new Thread(conditionThreadC, "Thread-C").start();

//        Thread.sleep(1000);
//
//        ThreadGroup group = Thread.currentThread().getThreadGroup();
//        ThreadGroup topGroup = group;
//
//        /* 遍历线程组树，获取根线程组 */
//        while (group != null) {
//            topGroup = group;
//            group = group.getParent();
//        }
//        /* 激活的线程数加倍 */
//        int estimatedSize = topGroup.activeCount() * 2;
//        Thread[] slackList = new Thread[estimatedSize];
//
//        int actualSize = topGroup.enumerate(slackList);
//        /* copy into a list that is the exact size */
//        Thread[] list = new Thread[actualSize];
//        System.arraycopy(slackList, 0, list, 0, actualSize);
//
//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i].getName());
//        }
    }

}

class PrintABC implements Runnable{

    //我之前一直有问题  就是因为这里没有设置为static  因为每个 PrintABC 对象这里都会不一致  之前没注意
    static volatile int sum = 0;
    static String flag = "A";


    Lock lock;
    Condition condition;
    String threadFlag;

    public PrintABC(Lock lock, Condition condition, String threadFlag) {
        this.lock = lock;
        this.condition = condition;
        this.threadFlag = threadFlag;
    }


    @Override
    public void run() {

        while (sum < 100){
            lock.lock();
            try {
//                condition.signalAll();
//                System.out.println(Thread.currentThread().getName());
                if(threadFlag.equals(flag) && sum < 100){
                    System.out.println(Thread.currentThread().getName() + "-> 执行" );
                    System.out.println(sum);
                    sum++;
                    if(sum % 3 == 0){
                        flag = "A";
                    }else if(sum % 3 == 1){
                        flag = "B";
                    }else {
                        flag = "C";
                    }
                    System.out.println(flag);
//                    condition.await();
                }
            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            finally {
                lock.unlock();
            }
        }
    }
}
