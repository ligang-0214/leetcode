package Acodetop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/4 10:16
 */
public class Code349_两个数组的交集_easy {

    public int[] intersection(int[] nums1, int[] nums2) {
        LinkedList<Integer> res = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                if (res.isEmpty() || res.getLast() != nums1[index1]) {
                    res.addLast(nums1[index1]);
                }
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        int[] a = new int[res.size()];
        int index = 0;
        for (Integer re : res) {
            a[index++] = re;
        }
        return a;

    }

}
