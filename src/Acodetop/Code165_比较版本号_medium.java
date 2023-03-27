package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 14:09
 */
public class Code165_比较版本号_medium {
    public static void main(String[] args) {
        compareVersion1("11", "10");
    }

    //有的面试官不让用 split  就需要用下面的方法
    public static int compareVersion1(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < ver1.length || j < ver2.length){
            String s1 = i == ver1.length ? "0" : ver1[i];
            String s2 = j == ver2.length ? "0" : ver2[j];
            int i1 = Integer.parseInt(s1);
            int i2 = Integer.parseInt(s2);
            if(i1 != i2){
                return i1 > i2 ? 1 : -1;
            }
            i = i == ver1.length ? i : i+1;
            j = j == ver2.length ? j : j+1;
        }
        return 0;
    }

    //双指针的方式
    public static int compareVersion2(String version1, String version2){
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0'; //这里*10再加  其实也相当于去掉了前导0
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }



}
