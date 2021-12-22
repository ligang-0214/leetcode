package C哈希表;

import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2021/12/21 9:43
 */
public class Code454_四数相加二 {
    public static void main(String[] args) {

    }

    /**
     * 和两数之和差不多，就是两两合一，然后就像是两数之和一样了
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> mapA = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(mapA.containsKey(nums1[i] + nums2[j])){
                    mapA.put(nums1[i] + nums2[j],mapA.get(nums1[i] + nums2[j]) + 1);
                }else {
                    mapA.put(nums1[i] + nums2[j],1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if(mapA.containsKey(0 - nums3[i] - nums4[j])){
                    res += mapA.get(0 - nums3[i] - nums4[j]);
                }
            }
        }
        return res;
    }


}
