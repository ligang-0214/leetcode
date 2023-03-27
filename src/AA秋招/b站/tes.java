package AA秋招.b站;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 松鼠
 * @data 2022/9/1 22:37
 */
public class tes {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            iterator.remove();
            System.out.println(next);
        }
        System.out.println(list.toString());

        Vector<Iterator> ve = new Vector<>();
    }
}
