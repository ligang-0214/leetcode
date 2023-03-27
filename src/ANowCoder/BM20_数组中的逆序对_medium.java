package ANowCoder;

/**
 * @author 松鼠
 * @data 2022/6/27 10:14
 */
public class BM20_数组中的逆序对_medium {

    long res = 0;
    public int InversePairs(int [] array) {
        if(array == null ){
            return 0;
        }
        merge(array , 0 , array.length - 1);
        return (int)(res % 1000000007);
    }

    private void merge(int[] array, int left, int right) {
        if(left == right)
            return;
        int mid = left + (right - left) / 2;
        merge(array , left , mid);
        merge(array , mid + 1 , right);
        partition(array , left , mid , right);
    }

    private void partition(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int head1 = left;
        int head2 = mid + 1;
        while (head1 <= mid && head2 <= right){
            if(array[head1] > array[head2]){
                res += mid - head1 + 1;
                temp[index++] = array[head2++];
            }else {
                temp[index++] = array[head1++];
            }
        }
        while (head1 <= mid){
            temp[index++] = array[head1++];
        }
        while (head2 <= right){
            temp[index++] = array[head2++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[left++] = temp[i];
        }
    }

}
