package AA秋招.zoom;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/8/10 18:44
 */
public class zoom2 {
    /**
     * 5
     * 1 Alice 2
     * Zoom Apple
     * 2 Bob
     * 2 Alice
     * 1 Bob 2
     * Apple Microsoft
     * 2 Bob
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LinkedList<String> temp = new LinkedList<>();
        while (N > 0){
            String s = sc.nextLine();
            if(s.startsWith("1") || s.startsWith("2")){
                N--;
            }
            temp.addLast(s);
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        while (!temp.isEmpty()) {
            String[] s1 = temp.removeFirst().split(" ");
            if (s1[0].equals("1")) {
                String[] names = temp.removeFirst().split(" ");
                ArrayList<String> list = new ArrayList<>();
                for (String name : names) {
                    list.add(name);
                }
                map.put(s1[1], list);
                while (!temp.isEmpty() && temp.getFirst().startsWith("2")) {
                    String[] check = temp.removeFirst().split(" ");
                    process(check[1], map);
                }
            }
        }

    }

    private static void process(String s, HashMap<String, ArrayList<String>> map) {
        if (!map.containsKey(s)) {
            System.out.println("error");
            return;
        } else {
            HashSet<String> hashSet = new HashSet<>(map.get(s));
            int curLen = map.get(s).size();

            Set<String> keySet = map.keySet();
            for (int i = 0; i < 10; i++) {
                for (String s1 : keySet) {
                    if (s1.equals(s)) {
                        continue;
                    } else {
                        ArrayList<String> strings = map.get(s1);
                        for (String string : strings) {
                            if(hashSet.contains(string)){
                                hashSet.addAll(new HashSet<>(strings));
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(hashSet.size() - curLen);
        }
    }


}
