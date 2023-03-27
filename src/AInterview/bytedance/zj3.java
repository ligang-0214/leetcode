package AInterview.bytedance;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/3/27 19:59
 */
public class zj3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        if(x % 2 == 0){
            x = x /2;
            queue.add(x);
            queue.add(x);
        }else {
            queue.add(x);
        }
        while (n > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer remove = queue.removeFirst();
                queue.addLast(remove + 1);
            }
            queue.sort((o1 , o2) -> {return o2 - o1;});
            ArrayList<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty() && queue.getFirst() % 2 != 0){
                temp.add(queue.removeFirst());
            }
            if(queue.isEmpty()){
                queue.addAll(temp);
            }else {
                Integer integer = queue.removeFirst();
                queue.add(integer / 2);
                queue.add(integer / 2);
                queue.addAll(temp);
            }
            n--;
        }
        queue.sort((o1 , o2) -> {return o2 - o1;});
        System.out.println(queue.getFirst());
    }
}
