package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/23 16:21
 */
public class Code42_接雨水_hard {

    //DP处理
    public int trapDP(int[] height) {
        int len = height.length;

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len-1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    //双指针
    public int trapLeftAndRight(int[] height){

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while (left <= right){
            if(height[left] < height[right]){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }else {
                    sum += leftMax - height[left];
                }
                left++;
            }else {
                if(height[right] > rightMax){
                    rightMax = height[right];
                }else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }




}
