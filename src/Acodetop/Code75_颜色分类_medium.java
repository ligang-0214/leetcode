package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/18 22:01
 */
public class Code75_颜色分类_medium {

    public void sortColors(int[] nums) {
        int lFlag = -1;
        int rFlag = nums.length;
        int i = 0;
        while (i < rFlag){
            if(nums[i] < 1){
                swap(nums , ++lFlag , i++);
            }else if(nums[i] > 1){
                swap(nums , i , --rFlag);
            }else {
                i++;
            }
        }
    }
    public void swap(int[] nums , int index1 , int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
