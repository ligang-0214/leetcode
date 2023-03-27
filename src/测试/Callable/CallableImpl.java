package 测试.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Author:松鼠
 * Date:2021/5/16 15:03
 */
public class CallableImpl implements Callable {
    public CallableImpl(String s) {
    }

    @Override
    public Object call() throws Exception {
        return new ArrayList<>().add("hhh");
    }
}
