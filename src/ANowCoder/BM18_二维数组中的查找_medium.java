package ANowCoder;

/**
 * @author 松鼠
 * @data 2022/6/27 9:30
 */
public class BM18_二维数组中的查找_medium {

    public boolean Find(int target, int [][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0){
            if(target == array[row][col]){
                return true;
            }else if(target > array[row][col]){
                row++;
            }else {
                col--;
            }
        }
        return  false;
    }

}
