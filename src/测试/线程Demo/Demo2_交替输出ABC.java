package 测试.线程Demo;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 松鼠
 * @data 2022/3/30 19:31
 */
public class Demo2_交替输出ABC {

    private static LinkedList<String> queue = new LinkedList();

    static {
        for (int i = 0; i < 10; i++) {
            queue.addLast("A");
            queue.addLast("B");
            queue.addLast("C");
        }
    }

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();// 默认非公平
        Condition condition = lock.newCondition();
        ConditionThread conditionThreadA = new ConditionThread(lock, condition, "A");
        ConditionThread conditionThreadB = new ConditionThread(lock, condition, "B");
        ConditionThread conditionThreadC = new ConditionThread(lock, condition, "C");
        new Thread(conditionThreadA, "Thread-A").start();
        new Thread(conditionThreadB, "Thread-B").start();
        new Thread(conditionThreadC, "Thread-C").start();

//        Thread.sleep(2000);
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;

        /* 遍历线程组树，获取根线程组 */
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        /* 激活的线程数加倍 */
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];

        int actualSize = topGroup.enumerate(slackList);
        /* copy into a list that is the exact size */
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);

//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i].getName());
//        }


    }

    static class ConditionThread implements Runnable {

        Lock lock;

        Condition condition;

        String threadFlag;

        public ConditionThread(Lock lock, Condition condition, String threadFlag) {
            this.lock = lock;
            this.condition = condition;
            this.threadFlag = threadFlag;
        }

        String flag = "A";
        @Override
        public void run() {
            while (!queue.isEmpty()) {
                lock.lock();
                try {
//                    condition.signalAll();
                    if (!queue.isEmpty()) {
                        String element = queue.getFirst();// 拿到队列头部的元素的 flag
                        if (null != element && element.equals(threadFlag)) {// 如果和当前线程的 flag 相同，则执行线程
                            queue.removeFirst();// 删除这个头部的元素
                            System.out.println(Thread.currentThread().getName() + "-> 执行");
                            atomicInteger.incrementAndGet();
                            System.out.println(atomicInteger.get());
                        }
                    }
//                    condition.await();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
