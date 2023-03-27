package K图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:松鼠
 * Date:2021/7/16 10:46
 */
public class Code547_省份数量 {
    public static void main(String[] args) {

    }

    /**
     * 深度优先遍历
     * @param isConnected
     * @return
     */
    public static int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) { //城市i没有被看过
                dfs(isConnected, visited, provinces, i); //顺着它开始深度遍历
                circles++;
            }
        }
        return circles;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }


    /**
     * 比上面的方法更简洁一些   但思路是一样的
     * 直接使用矩阵中isConnected[i][i]来记录是否询问过城市 i
     * @param isConnected
     * @return
     */
    public  int findCircleNum1(int[][] isConnected) {
        int circles = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 1) {
                isConnected[i][i] = 0;
                dfs1(isConnected, i);
                circles++;
            }
        }
        return circles;
    }

    public  void dfs1(int[][] isConnected, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && isConnected[j][j] == 1) {
                isConnected[j][j] = 0;
                dfs1(isConnected, j);
            }
        }
    }



    /**
     * 广度优先遍历
     * @param isConnected
     * @return
     */
    public int findCircleNum2(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int j = queue.remove();
                    visited[j] = true;
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.add(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;
    }

}
