package 测试;

/**
 * Author:松鼠
 * Date:2021/5/6 15:32
 */
public class People implements Cloneable{
    private String name;
    private int age;
    private Test test;

    /**
     * 深克隆
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        People p=null;
        p= (People) super.clone();
        p.test= (Test) test.clone();
        return p;
    }

    /**
     * 浅克隆
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return (测试.People) super.clone(); ;
//    }


//    void doWork(){
//        System.out.println("父类工作了");
//    }

    public People() {
    }
    public People(String name, int age, Test test) {
        this.name = name;
        this.age = age;
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
