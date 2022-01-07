package I贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/1/7 16:04
 */
public class Code736_划分字母区间 {

    //一个比较取巧的办法
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        //如果想省空间的话  可以把map换成数组 new int[26]
        HashMap<Character, Integer> map = new HashMap<>(); //记录某个字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),i);
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 要先处理这里end  比如遇到 “abadeced” 不先处理end的话 b会被单独切出来
            end = Math.max(end , map.get(s.charAt(i)));
            if(i == end){ //只有当 i 走到了 end 的位置 才会切割扔进结果集  中间其他的都不管  如果管了  那就不符合题意了
                res.add(end - start +1);
                start = i + 1;
            }
        }
        return res;
    }

}
