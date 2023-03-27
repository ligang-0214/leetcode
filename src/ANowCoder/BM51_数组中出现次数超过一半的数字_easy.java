package ANowCoder;

/**
 * @author 松鼠
 * @data 2022/6/23 10:24
 */
public class BM51_数组中出现次数超过一半的数字_easy {

    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 0;
        int condition = array[0];
        for(int i = 0 ; i < array.length ; i++){
            if(count == 0){
                condition = array[i];
            }
            if(condition == array[i]){
                count++;
            }else{
                count--;
            }
        }
        return condition;
    }

}
