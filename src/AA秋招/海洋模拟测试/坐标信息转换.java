package AA秋招.海洋模拟测试;

import javafx.scene.input.DataFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * @author 松鼠
 * @data 2022/11/2 9:55
 */
public class 坐标信息转换 {
    public static void main(String[] args) throws IOException {

        HashSet set = new HashSet();
        set.add("hhh");
        set.add(new String("hhh"));
        System.out.println(set.size());

        String len = Integer.toHexString((9) * 13);
        while (len.length() < 4) {
            len = "0" + len;
        }
        System.out.println(len);


//        String start = "19B1";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
//        String timeStamp = dateFormat.format(new Date());
//        String date = timeStamp; //处理日期
//        for (int i = 0; i < date.length(); i += 2) {
//            String temp = Long.toHexString(Long.parseLong(date.substring(i, i + 2)));
//            while (temp.length() < 2) {
//                temp = "0" + temp;
//            }
//            start = start + temp;
//        }
//        start += "C00285394306D01123924102FF";
//        System.out.println(start);
//        byte[] b1 = Hex2StringUtils.hexStringToByteArray(start);
//        OutputStream outputStream = new FileOutputStream(new File("D:/Allcode/leetcode/src/AA秋招/海洋模拟测试/1.txt"));
//        outputStream.write(b1);
//        System.out.println("结束");

    }
}
