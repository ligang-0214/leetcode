package ANowCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/6/23 11:25
 */
public class BM54_三数之和_medium {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length < 3) {
            return res;
        }
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                return res;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == 0) {
                    ArrayList<Integer> list = (ArrayList<Integer>) Arrays.asList(num[i], num[left], num[right]);
                    res.add(list);
                    while (left < right && num[right] == num[right - 1]) right--;
                    while (left < right && num[left] == num[left + 1]) left++;
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;

    }

}
