package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 16:48
 */
public class Code468_验证IP地址_medium {

    //在牛客看的题解
    //https://www.nowcoder.com/practice/55fb3c68d08d46119f76ae2df7566880?tpId=295&tqId=1024725&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295
    //1. 分割字符串时，使用limit = -1的split函数，使得字符串末尾或开头有一个'.'或':'也能分割出空的字符串
    //2. 使用Integer.parseInt()函数检查异常
    public String validIPAddress(String queryIP) {
        boolean ipv4 = validIPV4(queryIP);
        boolean ipv6 = validIPV6(queryIP);
        return  ipv4 ? "IPv4" : (ipv6 ? "IPv6" : "Neither");
    }

    private boolean validIPV4(String IP){
        String[] split = IP.split("\\." , -1);
        if(split.length != 4){
            return false;
        }
        for (String s : split) {
            //System.out.println(Integer.parseInt("012"));   输出的是 12  自动去掉前导0  所以要先判断前导0  再转换
            if(s.length() > 1 && s.charAt(0) == '0'){
                return false;
            }
            try { //转换异常也会返回false
                int parseInt = Integer.parseInt(s);
                if( parseInt < 0 || parseInt > 255){
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean validIPV6(String IP){
        String[] strs = IP.split(":", -1);
        if (strs.length != 8) {
            return false;
        }

        for (String str : strs) {
            if (str.length() > 4 || str.length() == 0) {
                return false;
            }
            try {
                int val = Integer.parseInt(str, 16); //十六进制转换
            } catch (NumberFormatException numberFormatException) {
                return false;
            }
        }
        return true;
    }

}
