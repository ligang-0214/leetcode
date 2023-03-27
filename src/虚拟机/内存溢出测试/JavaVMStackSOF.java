package 虚拟机.内存溢出测试;

/**
 * VM Args：-Xss128k   使用-Xss参数减少栈内存容量。
 * Author:松鼠
 * Date:2021/7/7 11:00
 */
public class JavaVMStackSOF {

    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
