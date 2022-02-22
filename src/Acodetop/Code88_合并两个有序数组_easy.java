package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/22 9:35
 */
public class Code88_合并两个有序数组_easy {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];

        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while (index1 < m || index2 < n){
            if(index1 == m){
                res[i++] = nums2[index2++];
            }else if(index2 == n){
                res[i++] = nums1[index1++];
            }else if(nums1[index1] <= nums2[index2]){
                res[i++] = nums1[index1++];
            }else {
                res[i++] = nums2[index2++];
            }
        }
        for (int j = 0; j < res.length; j++) {
            nums1[j] = res[j];
        }
    }

}
