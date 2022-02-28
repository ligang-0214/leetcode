package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/28 15:42
 */
public class Code718_最长重复子数组_medium {
    //我想称dp为神
    //https://programmercarl.com/0718.%E6%9C%80%E9%95%BF%E9%87%8D%E5%A4%8D%E5%AD%90%E6%95%B0%E7%BB%84.html#%E6%80%9D%E8%B7%AF
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2 +1];
        for (int i = 0; i < len1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < len2; i++) {
            dp[0][i] = 0;
        }
        int res = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                res = Math.max(res , dp[i][j]);
            }
        }
        return res;
    }

}
