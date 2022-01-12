package J动态规划;

/**
 * @author 松鼠
 * @data 2022/1/11 17:53
 */
public class Code63_不同路径二 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //上来第一个就是0  确实是自己疏忽了
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        int[][] dp = new int[M][N];
        //因为机器人只能向下或者向右走  所以第一行和第一列的每个位置只有一种到达的方式  所以都为1
        for (int i = 0; i < M; i++) {
            if (obstacleGrid[i][0] == 1) // 如果初始化时 遇到第一个有障碍物的格子 那后面都不可达  就为默认的0
                break;
            dp[i][1] = 1;
        }
        for (int i = 0; i < N; i++) {
            if (obstacleGrid[0][i] == 1) // 如果初始化时 遇到第一个有障碍物的格子 那后面都不可达  就为默认的0
                break;
            dp[1][i] = 1;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (obstacleGrid[i][j] == 1) { // 如果当前格子有障碍物 那它就不可达 设为0就好
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[M-1][N-1];
    }
}
