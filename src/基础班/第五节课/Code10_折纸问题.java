package 基础班.第五节课;

/**
 * Author:松鼠
 * Date:2021/6/29 16:54
 */
public class Code10_折纸问题 {
    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);

    }


    public static void printAllFolds(int n) {
        process(1 , n ,1);
    }
    //flag为1时表示down，为0时表示up
    private static void process(int i, int n, int flag) {
        //base case
        if(i > n){
            return;
        }
        process(i+1,n,1);
        System.out.print( flag == 1 ? "down " : "up ");
        process(i+1,n,0);
    }

}
