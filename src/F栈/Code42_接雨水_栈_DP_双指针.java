package F栈;

/**
 * @author 松鼠
 * @data 2021/12/23 10:54
 */
public class Code42_接雨水_栈_DP_双指针 {
    public static void main(String[] args) {

    }

    /**
     * 暴力解法   直接遍历到每个元素时  向左向右找到最大的值  然后    min(左边最大,右边最大) - 当前元素的大小
     * 这样就可以找到每个元素位置可以累计的雨水  然后把所有位置可积累雨水的量累加起来
     * 时间： O(n*n)  空间：O(1)
     * @param height
     * @return
     */
    public int trapForce(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }


    /**
     * 动态规划：在暴力方法中，我们仅仅为了找到最大值每次都要向左和向右扫描一次。但是我们可以提前存储这个值。
     * 时间： O(n)  空间：O(n)
     * @param height
     * @return
     */
    public int trapDP(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        //找到某个位置上左边最大的数  存到数组中
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        //找到某个位置上右边最大的数  存到数组中
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(height[i],rightMax[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(leftMax[i],rightMax[i]) - height[i];
        }

        return res;
    }


    /**
     * 时间： O(n)  空间：O(n)   由于时间和空间和DP是一样的  所以没看这个  直接看双指针的优化
     * @param height
     * @return
     */
    public int trapStack(int[] height){
        return 0;
    }


    /**
     * 和方法 2 相比，我们不从左和从右分开计算，我们想办法一次完成遍历。
     * 从动态编程方法中我们注意到，只要 right_max[i]>left_max[i] （元素 0 到元素 6），积水高度将由 left_max 决定，
     * 类似地 left_max[i]>right_max[i]（元素 8 到元素 11）。
     * 所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。
     * 当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
     * 我们必须在遍历时维护 left_max 和 right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
     * @param height
     * @return
     */
    public int trapLeftAndRight(int[] height){
        int res =0;
        int left = 0;
        int right = height.length -1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right){
            if(height[left] < height[right]){
                if(height[left] > leftMax)
                    leftMax = height[left];
                else
                    res  += leftMax - height[left];
                left++;
            }else {
                if(height[right] > rightMax)
                    rightMax = height[right];
                else
                    res  += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

}
