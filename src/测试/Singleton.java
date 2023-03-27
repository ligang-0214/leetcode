package 测试;

/**
 * @author 松鼠
 * @data 2022/3/8 8:52
 */
public class Singleton {
//    private volatile static Singleton singleton = null;  //两种都行   顺序无所谓
    private static volatile Singleton singleton = null;

    public Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}
