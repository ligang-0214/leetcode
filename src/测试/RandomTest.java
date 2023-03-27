package 测试;

import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/2/28 9:47
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextInt(7)+1);
        }
    }
}
