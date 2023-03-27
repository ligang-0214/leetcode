package 基础班.第二节课;

import java.util.Arrays;
import java.util.Random;

/**
 * Author:松鼠
 * Date:2021/6/2 19:55
 * 问题一
 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的
 * 数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)
 *
 * 问题二(荷兰国旗问题)
 * 给定一个数组arr,和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，
 * 大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Code05_HeLanFlag {
    public static void main(String[] args) {
        int[] arr=new int[]{3,4,5,6,7,4,3,5};
        int[] arr1=new int[]{3,5,6,3,4,5,2,6,9,0};
        problem1(arr,5);
        System.out.println(Arrays.toString(arr));
        problem2(arr1,5);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 问题一
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的
     * 数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)
     * @param arr
     * @param num
     */
    static void problem1(int[] arr,int num){
        int flag=-1;//用来标记小于等于num的位置
        int l=0;//获取左位置
        int r=arr.length-1;//获取右位置
        while (l<r){
            if(arr[l]<num){ //如果当前位置小于num则flag扩大
                swap(arr,l++,++flag);
            }else {
                l++;
            }
        }
    }

    /**
     * 问题二
     * 给定一个数组arr,和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，
     * 大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)
     * @param arr
     * @param num
     */
    static void problem2(int[] arr,int num){
        int lflag=-1;//用来标记小于num的位置
        int rflag=arr.length;//用来标记大于num的位置
        int l=0;//获取左位置
        while (l!=rflag){//遍历的位置与rflag是否碰头为终止条件
            if(arr[l]<num){
                swap(arr,l++,++lflag);
            }
            else if(arr[l]>num){
                swap(arr,l,--rflag);
            }else {
                l++;
            }
        }

    }


    /**
     * 置换函数
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
