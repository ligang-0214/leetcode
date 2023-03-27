package 测试.输入输出;

/**
 * @author 松鼠
 * @data 2022/7/23 10:45
 */
public class OutputTest {
    public static void main(String[] args) {

        // %n 是换行
        System.out.printf("输出：%d %n" , 20);

        // 小数点后保留两位
        System.out.printf("输出：%.2f %n" , 20.2678);

        // 共八位
        System.out.printf("输出：%8f %n" , 20.2678);


    }

}
