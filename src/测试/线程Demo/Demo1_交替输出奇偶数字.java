package 测试.线程Demo;

/**
 * @author 松鼠
 * @data 2022/3/14 14:28
 */
public class Demo1_交替输出奇偶数字 {
    public static void main(String[] args) throws InterruptedException {
        PrintNum p=new PrintNum();
        Thread thread1 = new Thread(p);
        Thread thread2 = new Thread(p);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
//        Thread.sleep(20);
        thread2.start();
    }
}


class PrintNum implements Runnable{
    int num=1;
    Object ob = new Object();
    @Override
    public void run() {
        synchronized (ob){
            while (true){
                ob.notify();//唤醒wait()的一个或者所有的线程
                if (num<=50){
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;
                }else {
                    break;
                }
                try {
                    ob.wait();//当前等待 并且会释放当前的锁，所以另一个线程就进来
//                    System.out.println(Thread.currentThread().getName()+": 我接着之前的wait方法执行");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
