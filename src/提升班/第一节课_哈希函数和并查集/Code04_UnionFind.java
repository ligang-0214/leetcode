package 提升班.第一节课_哈希函数和并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 实现并查集的方式很多（比如可以用链表或者hashmap等等）   但是为什么要下面这个结构呢？
 * 因为为了实现 union 和 findHead 两个方法的  时间复杂度都为O(1)
 *
 * Author:松鼠
 * Date:2021/7/27 15:01
 */
@SuppressWarnings("all")
public class Code04_UnionFind {

    /**
     * 设计的是比较通用的
     * @param <V>
     */
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap; //样本和自己设置的Element对应起来 起到连接的作用
        public HashMap<Element<V>, Element<V>> fatherMap; //key的父亲是value
        public HashMap<Element<V>, Integer> rankMap; //key这个元素所在集合的大小为value

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) { //将所给的样本封装起来  然后将3个map初始化
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }

        /**
         * 注意这个函数
         * 在找某个集合的父元素时  会将路径记录下来  找到父元素之后  会将沿路的元素都直接指向父元素
         * 好处：下次再找沿路上这些元素的父元素就会很快
         * @param element
         * @return
         */
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        /**
         * 其实这个函数有点多余  不重要
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                    rankMap.remove(small);
                }
            }
        }

    }
}
