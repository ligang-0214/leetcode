package 测试;

/**
 * Author:松鼠
 * Date:2021/5/7 9:57
 */
public class Manager extends People {
    private String gangwei;

    public Manager() {
    }

    public Manager(String gangwei) {
        this.gangwei = gangwei;
    }

    public Manager(String name, int age, Test test, String gangwei) {
        super(name, age, test);
        this.gangwei = gangwei;
    }

    public String getGangwei() {
        return gangwei;
    }

    public void setGangwei(String gangwei) {
        this.gangwei = gangwei;
    }

    public void doWork(){
        System.out.println("子类工作了！！");
    }


}
