package AInterview.meituan;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/12 17:15
 * 小美现在打音游。这个音游的玩法是这样的：
 * —— 共有n个房间。小美初始拥有一个指针，指在一号房间。
 * —— 游戏共持续m秒，每秒会有一个房间产生炸弹，小美的指针不能在这个房间中。
 * —— 每秒结束的瞬间，小美可以使用一次魔法，把指针切换到另一个房间中，该过程会消耗一个能量。
 * 你的任务是计算小美无伤通过音游所需要消耗的最小能量。
 * 保证第一秒的炸弹不发生在一号房间中。
 *
 * 输入描述
 * 第一行两个正整数 n 和 m，表示房间有 n 个，游戏持续 m 秒。
 * 第二行 m 个正整数，每个正整数在1~n 的范围内，第 i 个正整数表示第 i 秒时炸弹在哪个房间生成。
 * 数字间有空格隔开
 * 数据保证 n ＜= 10 , 1 <= m <= 10000
 *
 * 输出描述
 * 一行一个正整数，表示小美无伤通过音游所需要消耗的最少能量。
 */
public class MeiTuan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        process(n , nums);

    }

    private static void process(int n, int[] nums) {

    }

}
