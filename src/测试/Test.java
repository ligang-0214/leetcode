package 测试;

/**
 * Author:松鼠
 * Date:2021/5/6 15:34
 */
public class Test implements  Cloneable{
    private  int hh;

    /**
     * 为了实现深克隆 这里也需要重写clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Test(int hh) {
        this.hh = hh;
    }
    public Test() {
    }

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }
}
