package AInterview.wyLeiHuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/26 15:07
 */
public class leihuo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] words = str.split(" ");
        ArrayList<String> res = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            int wordLen = 0;
            if(Character.isUpperCase(words[i].charAt(words[i].length() - 1)) || Character.isLowerCase(words[i].charAt(words[i].length() - 1))){
                wordLen = words[i].length();
            }else {
                wordLen = words[i].length() - 1;
            }
//            System.out.println("当前长度" + stringBuffer.length());
//            System.out.println(words[i] + " 的长度" + wordLen);
            if(stringBuffer.length() >= 20){
                res.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
                stringBuffer.append(words[i] + " ");
            }else if((stringBuffer.length() + wordLen) <= (N + M)){
                stringBuffer.append(words[i] + " ");
            }else {
                res.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
                stringBuffer.append(words[i] + " ");
            }
//            System.out.println(stringBuffer.toString());

        }
        if(stringBuffer.length() > 0){
            res.add(stringBuffer.toString());
        }
        System.out.println(res.size());
        for (String re : res) {
            System.out.println(re);
        }
        //I am coordinator of the Latin video games Federation. I'm born, member of the UWOOyan game Developers Association.
        //6
        //I am coordinator of     19
        //the Latin video games   21
        //Federation. I'm born,   21
        //member of the UWOOyan   21
        //game Developers
        //Association.

    }
}
