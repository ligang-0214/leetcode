package 基础班.第二节课;

/**
 * Author:松鼠
 * Date:2021/5/27 16:15
 *
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 例子:[1,3,4,2,5] 1左边比1小的数，没有; 3左边比3小的数，1; 4左
 * 边比4小的数，1、3; 2左边比2小的数，1; 5左边比5小的数，1、3、4、2;
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class Code02_SmallSum {

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,4,2,5,6,8,7,2,1,9};
        int[] arr1=new int[]{1,3,4,2,5,6,8,7,2,1,9};

        comparator(arr1);
        System.out.println("最小和为："+ test01(arr));
        System.out.println("最小和为："+ comparator(arr1));
    }

    public static int test01(int[] arr){
        if(arr==null||arr.length < 2)
            return 0;
        int l=0,r=arr.length-1;
        return test01(arr,l,r);
    }

    /**
     * 实现递归
     * @param arr
     * @param l
     * @param r
     */
    public static int test01(int[] arr,int l,int r){
        if(l==r)
            return 0;
        int mid=l+((r-l)>>1);
        return test01(arr,l,mid)+test01(arr,mid+1,r)+process(arr,l,mid,r);
    }
    /**
     * 仿造归并排序处理业务逻辑
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static int process(int[] arr, int l, int mid, int r) {
        int p1 = l; //p1指向左半部分的开头
        int p2 = mid + 1; //p2指向右半部分的开头
        int[] temp = new int[r - l + 1];  //存放左右排序的结果
        int i = 0;
        int sum=0;
        while (p1 <= mid && p2 <= r) {
            //一定要写成arr[p1] < arr[p2]  如果带上 =   则遇到相等就会先拷贝左侧的数据
            //这样在计算sum0的时候就很麻烦
            if (arr[p1] < arr[p2]) {
                sum += arr[p1] * (r - p2 + 1);
                temp[i++] = arr[p1++];
            } else {
                temp[i++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[l++] = temp[i];
        }
        return sum;
    }


    /**
     * 对数器
     * @param arr
     */
    public static int comparator(int[] arr) {
        int sum1=0;
        if (arr == null || arr.length < 2) {
            return 0;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum1 += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return sum1;
    }
}
