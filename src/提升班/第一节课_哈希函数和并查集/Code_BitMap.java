package 提升班.第一节课_哈希函数和并查集;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * Author:松鼠
 * Date:2021/8/2 15:34
 */
public class Code_BitMap {
    public static void main(String[] args) {
        //正儿八经的bitmap
        BitSet bitSet = new BitSet(320);

        //手工实现的bitmap
        int[] arr = new int[10]; //4*8  * 10 ----> 320 bit  范围0 ~ 319
        // arr[0]  int 31 ~ 0  为什么从0开始？ 因为数字就是从0开始的。。。
        // arr[1]  int 63 ~ 32
        // arr[2]  int 95 ~ 64
        int i = 178; //比如说现在想取得第178位置的bit状态
        int numIndex = 178/32;
        int bitIndex = 178%32;

        //拿到178位置的状态
        int flag = (   (arr[numIndex]>>(bitIndex))  & 1  );

        //把第178位置的状态改为1
        arr[numIndex] = arr[numIndex] | (1 << (bitIndex));

        //把第178位置的状态改为0
        arr[numIndex] = arr[numIndex] & (~  (1 << (bitIndex)));


        Code04_UnionFind.UnionFindSet<String> stringUnionFindSet =
                new Code04_UnionFind.UnionFindSet<>(new ArrayList<>());



    }
}
