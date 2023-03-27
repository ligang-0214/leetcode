package AA秋招.思科;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author 松鼠
 * @data 2022/9/20 20:11
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        char[] res = new char[n];
        Arrays.fill(res, '1');
        int cur = n;
        char tempChar = 'A';
        for (int i = n - 1; i >= 0 && cur > 0; --i) {
            int pos = -1;
            for (int j = 0; j < n; j++) {
                if (nums[j] == temp[i]) {
                    if (res[j] != '1')
                        continue;
                    res[j] = tempChar;
                    cur--;
                    int count = m;
                    for (int k = j + 1; k < n && count > 0; k++) {
                        if (res[k] == '1') {
                            res[k] = tempChar;
                            cur--;
                            count--;
                        }
                    }
                    tempChar = tempChar == 'A' ? 'B' : 'A';
                }
            }

        }
        System.out.println(new String(res));


    }
}
