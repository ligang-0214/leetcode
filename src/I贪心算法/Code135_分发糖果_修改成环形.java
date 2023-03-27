package I贪心算法;

/**
 * @author 松鼠
 * @data 2022/1/7 10:37
 */
public class Code135_分发糖果_修改成环形 {
    // 这题是看Code Top上的人提到  笔试题有做到过  没验证过答案对不对  但自己举了几个例子验证了
    public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }

        int[] res = new int[ratings.length];

        //首、尾两个元素拼接 只有两种情况：相等   不等
        if(ratings[0] > ratings[ratings.length -1]){ //如果首 大于 尾  那么起始一定是2  其他情况照旧
            res[0] = 2;
        }else {
            res[0] = 1;
        }

        //从前往后走一遍  计算某个位置上比它左边大的情况
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1] + 1;
            }else {
                res[i] = 1;
            }
        }
        //如果 尾 大于 首   那么 尾 必须加1  不然闭合成环的结果就会受到影响
        if(ratings[0] < ratings[ratings.length -1]){
            res[ratings.length -1] += 1;
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
