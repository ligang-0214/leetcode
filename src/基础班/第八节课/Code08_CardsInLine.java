package 基础班.第八节课;

/**
 * Author:松鼠
 * Date:2021/7/21 16:00
 */
public class Code08_CardsInLine {
    public static void main(String[] args) {
        int[] arr = {1,4,9,10,8};
        System.out.println(win1(arr));
    }


    /**
     * 解法一   我真的没搞懂
     * @param arr
     * @return
     */
    public static int win1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(first(arr,0,arr.length-1),second(arr,0,arr.length-1));
    }

    private static int first(int[] arr, int left, int right) {
        if(left == right){
            return arr[left];
        }
        return Math.max((arr[left] + second(arr,left+1,right)),
                (arr[right] + second(arr,left,right - 1))  );

    }

    private static int second(int[] arr, int left, int right) {
        if(left == right){
            return 0;
        }
        return Math.min( first(arr,left,right-1),first(arr,left+1,right)  );

    }


    /**
     * 方法二  好像是动态规划的解法
     * @param arr
     * @return
     */
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

}
