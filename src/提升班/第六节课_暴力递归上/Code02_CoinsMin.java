package 提升班.第六节课_暴力递归上;

import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/9/1 10:33
 */
@SuppressWarnings("all")
public class Code02_CoinsMin {
    public static void main(String[] args) {
        int[] arr = {5,3,2};
        int[] arr1 = {1,2,5};
//        System.out.println(minCoins1(arr, 22));
        System.out.println(minCoins1(arr1, 4));
    }

    //方法一：使用暴力递归的方式
    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int i, int aim) {
        if(aim < 0){ //超过了总共的aim
            return -1;
        }
        if(aim == 0){ // 刚好凑到aim  返回0是有意义的
            return 0;
        }
        // aim 大于0   看看还有没有硬币可以继续凑
        if(i == arr.length){
            return -1;
        }
        // aim 大于0 且还有硬币
        int process1 = process1(arr, i + 1, aim); // 不用当前硬币
        int process2 = process1(arr, i + 1, aim - arr[i]); //用当前硬币
        if(process1 == -1 && process2 == -1){ //如果用不用当前硬币都不能得到结果 就只能返回-1
            return -1;
        }else { // 此时代表至少有一种方式可以成功
            if(process1 == -1){
                return process2 + 1;
            }
            if (process2 == -1){
                return process1;
            }
            return Math.min(process1, process2 + 1);
        }
    }

    // //方法二：记忆化搜索 用空间换时间 虽然使用了dp表  但是没有使用转移方程  此时不算是dp
    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        Arrays.fill(dp,-2); //因为-1和0都有意义  所以选了-2

        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int i, int aim, int[][] dp) {
        if(aim < 0){ //超过了总共的aim
            return -1;
        }

        if(dp[i][aim] != -2){ // 如果当前位置有计算过
            return dp[i][aim];
        }

        if(aim == 0){ // 刚好凑到aim  返回0是有意义的
            dp[i][aim] = 0;
            return 0;
        }
        // aim 大于0   看看还有没有硬币可以继续凑
        if(i == arr.length){
            dp[i][aim] = -1;
            return -1;
        }
        // aim 大于0 且还有硬币
        int process1 = process1(arr, i + 1, aim); // 不用当前硬币
        int process2 = process1(arr, i + 1, aim - arr[i]); //用当前硬币
        if(process1 == -1 && process2 == -1){ //如果用不用当前硬币都不能得到结果 就只能返回-1
            dp[i][aim] = -1;
            return -1;
        }else { // 此时代表至少有一种方式可以成功
            if(process1 == -1){
                dp[i][aim] = process2 + 1;
            }else if (process2 == -1){
                dp[i][aim] = process1;
            }else {
                dp[i][aim] = Math.min(process1, process2 + 1);
            }
            return dp[i][aim];
        }
    }


    //方法三：利用动态转移方程来得到整个dp表内容
    public static int minCoins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // 设置最后一排的值，除了dp[N][0]为0之外，其他都是-1
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        for (int i = N - 1; i >= 0; i--) { // 从底往上计算每一行
            for (int rest = 0; rest <= aim; rest++) { // 每一行都从左往右
                dp[i][rest] = -1; // 初始时先设置dp[i][rest]的值无效
                if (dp[i + 1][rest] != -1) { // 下面的值如果有效
                    dp[i][rest] = dp[i + 1][rest]; // dp[i][rest]的值先设置成下面的值
                }
                // 左边的位置不越界并且有效
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) { // 如果之前下面的值无效
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else { // 说明下面和左边的值都有效，取最小的
                        dp[i][rest] = Math.min(dp[i][rest],dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }


    // 当前考虑的面值是arr[i]，还剩rest的钱需要找零
    // 如果返回-1说明自由使用arr[i..N-1]面值的情况下，无论如何也无法找零rest
    // 如果返回不是-1，代表自由使用arr[i..N-1]面值的情况下，找零rest需要的最少张数
    public static int processTemp(int[] arr, int i, int rest) {
        // base case：
        // 已经没有面值能够考虑了
        // 如果此时剩余的钱为0，返回0张
        // 如果此时剩余的钱不是0，返回-1
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        // 最少张数，初始时为-1，因为还没找到有效解
        int res = -1;
        // 依次尝试使用当前面值(arr[i])0张、1张、k张，但不能超过rest
        for (int k = 0; k * arr[i] <= rest; k++) {
            // 使用了k张arr[i]，剩下的钱为rest - k * arr[i]
            // 交给剩下的面值去搞定(arr[i+1..N-1])
            int next = processTemp(arr, i + 1, rest - k * arr[i]);
            if (next != -1) { // 说明上面process处理的过程有效
                //res为-1：在当前循环下第一次找到一个复合的条件
                //res不为-1：在当前循环中找到第二、三...次复合的情况  这时就要比较大小
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }



}
