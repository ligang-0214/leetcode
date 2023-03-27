package 测试;

/**
 * Author:松鼠
 * Date:2021/5/11 10:02
 */
public class Test4 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;

        /**
         * 正常匿名内部类的写法
         */
//        display(new 测试.Calculable() {
//            @Override
//            public int calculateInt(int a, int b) {
//                return a+b;
//            }
//        },n1,n2);

        /**
         * 使用lambda表达式的方式
         */
//        display((int a,int b)-> a+b,n1,n2);

        /**
         * 使用引用的方式
         */
        // 打印加法计算结果  Class::staticMethod
        display(LambdaDemo::add, n1, n2);
        LambdaDemo d = new LambdaDemo();
        // 打印减法计算结果   object::instanceMethod
        display(d::sub, n1, n2);

    }
    /**
     * 打印计算结果
     *
     * @param calc Lambda表达式
     * @param n1   操作数1
     * @param n2   操作数2
     */
    public static void display(Calculable calc, int n1, int n2) {
        System.out.println(calc.calculateInt(n1, n2));
    }

}
