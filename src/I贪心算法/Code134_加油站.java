package I贪心算法;

/**
 * @author 松鼠
 * @data 2022/1/7 9:34
 */
public class Code134_加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
        }
        if(totalSum < 0) //如果gas总和小于cost总和  那一定不可能转一圈
            return -1;

        int curSum = 0;
        int resultIndex = 0;
        //因为已经得到验证可以跑一圈 这里就放心验
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            if(curSum < 0){ //说明中途某个位置不可达
                resultIndex = i + 1; //那接着从i+1开始接着验证
                curSum = 0;
            }
        }
        return resultIndex;
    }

}
