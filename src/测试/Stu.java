package 测试;

/**
 * Author:松鼠
 * Date:2021/5/7 15:10
 */
public class Stu<N, A, S>  {
    private N name; // 姓名
    private A age; // 年龄
    private S sex; // 性别

    public N getName() {
        return name;
    }

    public void setName(N name) {
        this.name = name;
    }

    public A getAge() {
        return age;
    }

    public void setAge(A age) {
        this.age = age;
    }

    public S getSex() {
        return sex;
    }

    public void setSex(S sex) {
        this.sex = sex;
    }
}
