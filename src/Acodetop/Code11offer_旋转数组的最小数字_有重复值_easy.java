package Acodetop;

/**
 * @author 松鼠
 * @data 2022/6/27 11:01
 */
public class Code11offer_旋转数组的最小数字_有重复值_easy {

    // 这个主要是元素可以有重复值  所以会多一些判断   和BM21一样
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
