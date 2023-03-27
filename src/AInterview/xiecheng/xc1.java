package AInterview.xiecheng;

/**
 * @author 松鼠
 * @data 2022/3/24 19:36
 */
public class xc1 {
    public static void main(String[] args) {
        process(2);
        process(15);
        process(21);
        process(30);
        process(40);
    }



    public static void process(int num){
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if(i == 0){
                for (int j = 1; j < 9; j++) {
                    int check = check(s, i, j);
                    if(check > 0){
                        System.out.println(check);
                        return;
                    }
                }
            }else {
                for (int j = 0; j < 9; j++) {
                    int check = check(s, i, j);
                    if(check > 0){
                        System.out.println(check);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static int check(String s, int startIndex, int addNum) {
        String s1 = s.substring(startIndex, startIndex + 1);
        String s2 = s.substring(startIndex + 1, s.length());
        String temp = s1 + addNum + s2;
        if(Integer.valueOf(temp) % 7 == 0){
            return Integer.valueOf(temp);
        }
        return -1;
    }
}
