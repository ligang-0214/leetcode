package AA秋招.欧科云链;

/**
 * @author 松鼠
 * @data 2022/9/16 14:55
 */
public class demo2 {

    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        process(coins, 0, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void process(int[] arr, int index, int aim) {
        if (aim < 0) {
            return;
        }
        if (aim == 0) {
            res = Math.min(res, index);
        }

        for (int j = 0; j < arr.length; j++) {
            process(arr, index + 1, aim - arr[j]);
        }

    }

}
