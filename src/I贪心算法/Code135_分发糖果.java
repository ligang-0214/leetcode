package I贪心算法;

/**
 * @author 松鼠
 * @data 2022/1/7 10:10
 */
public class Code135_分发糖果 {

    // 这道题目要确定一边之后，再确定另一边，例如比较每一个孩子的左边，然后再比较右边，
    // 如果两边一起考虑一定会顾此失彼。
    public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }

        int[] res = new int[ratings.length];
        res[0] = 1;

        //从前往后走一遍  计算某个位置上比它左边大的情况
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1] + 1;
            }else {
                res[i] = 1;
            }
        }
        //从后往前走一遍  计算某个位置上比它右边大的情况
        for (int i = ratings.length - 2; i >= 0; i--) { //注意这里的起始位置
            if(ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i+1] + 1 , res[i]); //举个例子最清晰
            }
        }

        int result = 0;
        for (int re : res) {
            result += re;
        }
        return result;
    }

}
