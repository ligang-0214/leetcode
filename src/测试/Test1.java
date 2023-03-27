package 测试;

/**
 * Author:松鼠
 * Date:2021/5/6 15:37
 */
public class Test1 {
    public static void main(String[] args) throws CloneNotSupportedException {
//        测试.Test test = new 测试.Test(1);
//        测试.People people = new 测试.People("hhhhh",5,test);
//        测试.People people1;
//        people1=people;
//        System.out.println("直接赋值后的结果：");
//        System.out.println(people);
//        System.out.println(people1);
//        测试.People people3= (测试.People) people.clone();
//        System.out.println("深克隆后people和test的结果：");  //替换浅克隆见People中的方法
//        System.out.println(people);
//        System.out.println(people3);
//        System.out.println(people.getTest());
//        System.out.println(people3.getTest());

        boolean[] a = new boolean[2];
        System.out.println(a[0]);



        People[] people = new People[3];
        Test test = new Test(1);
        Manager manager = new Manager("hhhhh",5,test,"jingli");
        people[0]=manager;
//        manager.doWork();
        People people1=new Manager("hhhhh",5,test,"chushi");
        ((Manager) people1).doWork();

    }
}
