package 测试;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Author:松鼠
 * Date:2021/5/6 16:30
 */
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException {

        for (int i = 1; i <= 30; i+= 1) {
            System.out.println(i / 10.0);
        }



//        String name;
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter class name (e.g. java.util.Date): ");
//        name = in.next();
//        Class<?> aClass = Class.forName(name);

//        Class<测试.People> aClass = 测试.People.class;
//        System.out.println(aClass.getName());   //测试.People
//        printFields(aClass);

    }

    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields)
        {
            Class type = f.getType();
            String name = f.getName();
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print("修饰符："+modifiers + " ");
            System.out.println("返回类型："+type.getName() + " " + "字段名："+name +";");

            System.out.println(f.toString());

        }
    }
}
