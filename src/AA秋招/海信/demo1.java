package AA秋招.海信;

/**
 * @author 松鼠
 * @data 2022/9/15 18:59
 */
public class demo1 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 根据图形的周长计算该图形面积
     * @param shape string字符串 图形类型，值为 “circle” 表示图形为圆形，值为 “square” 表示图形为正方形
     * @param perimeter int整型 图形的周长
     * @return int整型
     */
    public int getArea (String shape, int perimeter) {
        if(perimeter <= 0){
            return 0;
        }
        // write code here
        if(shape.equals("circle")){
            int r = (int)(perimeter / 6.28d);
            return (int)Math.ceil(r * r * Math.PI);
        }else if(shape.equals("square")){
            return (int)((perimeter / 4) * (perimeter / 4));
        }else {
            return 0;
        }
    }
}
