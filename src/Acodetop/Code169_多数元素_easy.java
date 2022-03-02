package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 11:20
 */
public class Code169_多数元素_easy {

    //方法太巧妙了
    public int majorityElement(int[] nums) {
        Integer flag = null;
        int count = 0;

        for (int num : nums) {
            if(count == 0){
                flag = num;
            }
            count += flag == num ? 1 : -1 ;
        }
        return flag;
    }

}
