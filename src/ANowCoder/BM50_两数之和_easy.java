package ANowCoder;

import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/6/23 10:17
 */
public class BM50_两数之和_easy {

    public int[] twoSum (int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])){
                res[0] = map.get(target - numbers[i]);
                res[1] = i+1;
                break;
            }
            map.put(numbers[i] , i+1);
        }
        return res;
    }

}
