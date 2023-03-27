package ANowCoder;

/**
 * @author 松鼠
 * @data 2022/6/27 10:48
 */
public class BM22_比较版本号_medium {

    public int compare (String version1, String version2) {
        // write code here
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

}
