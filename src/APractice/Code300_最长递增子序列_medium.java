package APractice;

import java.util.Arrays;

/**
 * @author 松鼠
 * @data 2022/7/30 14:32
 */
public class Code300_最长递增子序列_medium {

    // 时间：O(N * N)
    public int lengthOfLIS1(int[] nums) {
        // dp[i] 表示：以 nums[i] 结尾 的「上升子序列」的长度。
        // 注意：这个定义中 nums[i] 必须被选取，且必须是这个子序列的最后一个元素
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 时间：O( N * log(N) )   使用二分查找优化第二层循环
    // 如果需要输出子序列  tails数组中的内容不一定是答案  比如 78912   最后tails中的内容会是 129
    // https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    // 直接看文字确实不太好懂，加个例子就比较容易明白，比如序列是78912345，前三个遍历完以后tail是789，
    // 这时候遍历到1，就得把1放到合适的位置，于是在tail二分查找1的位置，变成了189（如果序列在此时结束，因为res不变，所以依旧输出3），
    // 再遍历到2成为129，然后是123直到12345
    // 官方给的例子不太好，即没有我例子中1要代替7的过程，官例中每次替代都是替代tail的最后一个数
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) // 这里相当于j没动  一直是i往上加
                res++;
        }
        return res;
    }

}
