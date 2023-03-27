package 测试.Synchronized;

import java.util.concurrent.Executors;

/**
 * @author 松鼠
 * @data 2022/7/6 17:00
 */
public class Test {
    //为了查看class文件中加锁的指令
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
        Object o = new Object();
        synchronized (o){
            System.out.println("hhh");
        }





    }
    public synchronized void test(){
        System.out.println("jjj");
    }

}
