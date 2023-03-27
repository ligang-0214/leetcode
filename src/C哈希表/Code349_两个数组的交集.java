package C哈希表;

import java.util.HashSet;

/**
 * @author 松鼠
 * @data 2021/12/20 14:45
 */
public class Code349_两个数组的交集 {
    public static void main(String[] args) {

    }


    /**
     * 这个主要是哈希表概念的简单应用
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return null;

        HashSet<Integer> coll = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            coll.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if(coll.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }

        int[] ints = new int[res.size()];
        int i =0;
        for (Integer re : res) {
            ints[i++] = re;
        }
        return ints;
    }

}
