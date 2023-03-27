package AA秋招.特斯拉;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 松鼠
 * @data 2022/8/28 11:19
 */
public class demo1 {
    public static void main(String[] args) {

    }
    public boolean solution(int[] A) {
        // write your code in Java SE 8
        if(A.length % 2 != 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if(map.containsKey(i)){
                Integer integer = map.get(i);
                map.put(i , ++integer);
            }else {
                map.put(i , 1);
            }
        }
        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
            if(map.get(integer) % 2 != 0){
                return false;
            }
        }
        return true;


    }
}
