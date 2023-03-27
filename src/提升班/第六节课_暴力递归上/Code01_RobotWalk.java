package 提升班.第六节课_暴力递归上;

import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/8/31 19:32
 */
public class Code01_RobotWalk {
    //方法一：使用暴力递归的方式
    public static int ways1(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }

        // 总共N个位置，从M点出发，还剩K步，返回最终能达到P的方法数
        return walk1(N, M, K, P);
    }

    /**
     * 使用暴力递归的方式, 会发现时间复杂度很高  因为中间有重复计算的部分
     * 该函数的含义：只能在1~N这些位置上移动，当前在cur位置，走完rest步之后，停在P位置的方法数作为返回值返回
     * @param N : 位置为1 ~ N，固定参数
     * @param cur : 当前在cur位置，可变参数
     * @param rest : 还剩res步没有走，可变参数
     * @param P : 最终目标位置是P，固定参数
     * @return
     */
    public static int walk1(int N, int cur, int rest, int P) {
        // 如果没有剩余步数了，当前的cur位置就是最后的位置
        // 如果最后的位置停在P上，那么之前做的移动是有效的
        // 如果最后的位置没在P上，那么之前做的移动是无效的
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        // 如果还有rest步要走，而当前的cur位置在1位置上，那么当前这步只能从1走向2
        // 后续的过程就是，来到2位置上，还剩rest-1步要走
        if (cur == 1) {
            return walk1(N, 2, rest - 1, P);
        }
        // 如果还有rest步要走，而当前的cur位置在N位置上，那么当前这步只能从N走向N-1
        // 后续的过程就是，来到N-1位置上，还剩rest-1步要走
        if (cur == N) {
            return walk1(N, N - 1, rest - 1, P);
        }
        // 如果还有rest步要走，而当前的cur位置在中间位置上，那么当前这步可以走向左，也可以走向右
        // 走向左之后，后续的过程就是，来到cur-1位置上，还剩rest-1步要走
        // 走向右之后，后续的过程就是，来到cur+1位置上，还剩rest-1步要走
        // 走向左、走向右是截然不同的方法，所以总方法数要都算上
        return walk1(N, cur + 1, rest - 1, P) + walk1(N, cur - 1, rest - 1, P);
    }


    //方法二：记忆化搜索 用空间换时间 虽然使用了dp表  但是没有使用转移方程  此时不算是dp
    public static int ways2(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp,-1);

        // 总共N个位置，从M点出发，还剩K步，返回最终能达到P的方法数
        return walk2(N, M, K, P, dp);
    }

    public static int walk2(int N, int cur, int rest, int P, int[][] dp){
        //如果已经计算过了  直接取结果
        if(dp[rest][cur] != -1){
            return dp[rest][cur];
        }
        //如果dp没有命中
        if (rest == 0) {
            dp[rest][cur] = cur == P ? 1 : 0;
            return dp[rest][cur];
        }

        if(cur == 1){
            dp[rest][cur] = walk2(N, cur + 1 , rest - 1 , P ,dp);
        }else if(cur == N ){
            dp[rest][cur] = walk2(N, cur - 1 , rest - 1 , P ,dp);
        }else {
            dp[rest][cur] = walk2(N, cur + 1 , rest - 1 , P ,dp) + walk2(N, cur - 1 , rest - 1 , P ,dp);
        }
        return dp[rest][cur];
    }



    //方法三：利用动态转移方程来得到整个dp表内容
    public static int ways3(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1; // rest为0这一行数据  只有P这个位置为1  其他都是0  因为
        for (int i = 1; i <= K; i++) { //第一行数据已经处理过了  所以从第二行开始
            for (int j = 1; j <= N; j++) { // 为了方便表示 第0列数据不要  从第1列开始
                if (j == 1) { //第一列数据只能跳到第二列  所以只跟 dp[i - 1][2] 有关
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) { //第N列数据只能跳到第 N-1 列  所以只跟 dp[i - 1][N - 1] 有关
                    dp[i][j] = dp[i - 1][N - 1];
                } else { // 中间位置可以往左/右两边跳
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        //最后返回所需要的结果
        return dp[K][M];
    }



}
