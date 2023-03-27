package APractice;

/**
 * @author 松鼠
 * @data 2022/7/30 16:51
 */
public class Code42_接雨水_hard {

    // DP的解法
    public int trap1(int[] height) {
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int pre = 0;
        for (int i = 0; i < length; i++) {
            pre = Math.max(pre, height[i]);
            leftMax[i] = pre;
        }
        pre = 0;
        for (int i = length - 1; i >= 0; i--) {
            pre = Math.max(pre, height[i]);
            rightMax[i] = pre;
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }


    // 双指针的解法  此解法不熟
    public int trap2(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftMax = height[0];
        int rightMax = height[length - 1];
        int res = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }


}
