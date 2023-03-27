package Acodetop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/1 11:35
 */
public class Code442_数组中重复的数据_medium {

    // 原地哈希法
    //题目说了 每个整数出现一次或者两次  获益不用set 直接扔进list也是可以的
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                set.add(nums[i]);
            }
        }
        res.addAll(set);
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
