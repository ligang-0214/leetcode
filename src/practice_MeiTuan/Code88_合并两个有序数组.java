package practice_MeiTuan;

/**
 * @author 松鼠
 * @data 2022/3/29 14:43
 */
public class Code88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0){
            if(nums1[m] >= nums2[n]){
                nums1[cur--] = nums1[m--];
            }else {
                nums1[cur--] = nums2[n--];
            }
        }
        while (m >= 0){
            nums1[cur--] = nums1[m--];
        }
        while (n >= 0){
            nums1[cur--] = nums2[n--];
        }
    }

}
