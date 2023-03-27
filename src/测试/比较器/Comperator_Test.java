package 测试.比较器;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Author:松鼠
 * Date:2021/6/4 15:48
 */
public class Comperator_Test implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public Comparator thenComparing(Comparator other) {
        return null;
    }

    @Override
    public Comparator reversed() {
        return null;
    }

    @Override
    public Comparator thenComparing(Function keyExtractor) {
        return null;
    }

    @Override
    public Comparator thenComparing(Function keyExtractor, Comparator keyComparator) {
        return null;
    }
}
