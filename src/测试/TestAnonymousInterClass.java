package 测试;

/**
 * Author:松鼠
 * Date:2021/5/11 20:15
 */
public class TestAnonymousInterClass {
    int a=10;
    private void show() {
        int b=10;
        Out anonyInter = new Out() {
            // 获取匿名内部类的实例
            void show() {
                System.out.println("调用匿名类中的 show() 方法" + a);
                System.out.println("调用匿名类中的 show() 方法" + b);
            }
        };
        anonyInter.show();
    }
    public static void main(String[] args) {
        TestAnonymousInterClass test = new TestAnonymousInterClass();
        test.show();

    }
}
