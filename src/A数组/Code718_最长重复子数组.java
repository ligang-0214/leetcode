package A数组;

/**
 * Author:松鼠
 * Date:2021/9/16 15:46
 */
public class Code718_最长重复子数组 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,2,1};
        int[] arr2 = {3,2,1,4,7};
        System.out.println(findLength(arr1, arr2));

    }

    public static int findLength(int[] nums1, int[] nums2) {
        return nums1.length > nums2.length ? process(nums2,nums1) : process(nums1,nums2);
    }

    //A是短的数组  B是长的数组
    //相当于A不动  B从A的左边往后滑动（或者想成   B不动 B从A的后面 从后往前滑动）
    public static int process(int[] A, int[] B) {
        int aLength = A.length;
        int bLength = B.length;
        int res = 0;
        //A开始进入B这一段
        for (int i = 1; i <= aLength ; i++) {
            res = Math.max(maxLength(A,B,0,bLength-i,i),res);
        }
        //A在B里面这一段
        for (int i = bLength - aLength ; i >= 0 ; i--) {
            res = Math.max(maxLength(A,B,0,i,aLength),res);
        }
        //A离开B这一段
        for (int i = 1; i < aLength ; i++) {
            res = Math.max(maxLength(A,B,i,0,aLength-i),res);
        }
        return res;
    }

    public static int maxLength(int[] A, int[] B, int startA, int startB, int len) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < len ; i++) {
            if(A[startA + i] == B[startB + i] ){
                count++;
            }else {
                res = Math.max(res,count);
                count = 0;
            }
        }
        return count >0 ? Math.max(res,count) : res;
    }
}
