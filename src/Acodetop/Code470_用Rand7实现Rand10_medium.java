package Acodetop;

import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/2/28 9:45
 */
public class Code470_用Rand7实现Rand10_medium {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(rand5To7());
        }
    }


    public static int rand10() {
        int row, col, idx;
        do {
            row = new Random().nextInt(7) + 1;
            col = new Random().nextInt(7) + 1;
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return idx % 10 + 1;
    }

    //理解了之后随便写
    public static int rand2() {
        int row, col, idx;
        do {
            row = new Random().nextInt(7) + 1;
            col = new Random().nextInt(7) + 1;
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return idx / 20 + 1;
    }

    public static int rand5To7() {
        int row, col, idx;
        do {
            row = new Random().nextInt(5) + 1;
            col = new Random().nextInt(5) + 1;
            idx = col + (row - 1) * 5;
        } while (idx > 21);
        return idx % 7  + 1;
    }


}
