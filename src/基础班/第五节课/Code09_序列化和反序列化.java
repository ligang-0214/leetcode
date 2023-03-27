package 基础班.第五节课;

import sun.security.util.DerEncoder;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Author:松鼠
 * Date:2021/6/29 9:13
 */
@SuppressWarnings("all")
public class Code09_序列化和反序列化 {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        System.out.println("前序遍历的序列化编码："+serialByPre(head));
        Code02_打印一个可视化的二叉树.printTree(reconByPreString(serialByPre(head)));
        System.out.println("层次遍历的序列化编码："+serialByLevel(head));
        Code02_打印一个可视化的二叉树.printTree(reconByLevelString(serialByLevel(head)));

//        System.out.println("中序遍历的序列化编码："+serialByIn(head));
//        Code02_打印一个可视化的二叉树.printTree(reconByInString(serialByIn(head)));

    }

    /**
     * 通过前序遍历生成序列化的字符串
     * @param head
     * @return
     */
    public static String serialByPre(Node head){
        if(head == null){
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    /**
     * 利用前序遍历的字符串生成二叉树
     * @param preStr
     * @return
     */
    public static Node reconByPreString(String preStr){
        String[] split = preStr.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            queue.add(split[i]);
        }
        return reconPreOrder(queue);
    }
    public static Node reconPreOrder(LinkedList<String> queue){
        String s = queue.remove();
        if(s.equals("#")){
            return null;
        }
        Node node = new Node(Integer.parseInt(s));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }


    /**
     * 通过层次遍历生成序列化的字符串
     * @param head
     * @return
     */
    public static String serialByLevel(Node head){
        if (head == null){
            return "#_";
        }
        LinkedList<Node> queue = new LinkedList<>();
        String res = head.value + "_";
        queue.add(head);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            if (node.left != null){
                queue.add(node.left);
                res += node.left.value + "_";
            }else {
                res += "#_";
            }
            if(node.right != null){
                queue.add(node.right);
                res += node.right.value + "_";
            }else {
                res += "#_";
            }
        }
        return res;
    }

    /**
     * 使用层次遍历生成的字符串生成二叉树
     * @param levelStr
     * @return
     */
    public static Node reconByLevelString(String levelStr){
        String[] strings = levelStr.split("_");
        int index = 0;
        Node head = generateNodeByString(strings[index++]);
        if (head == null){
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            node.left = generateNodeByString(strings[index++]);
            node.right = generateNodeByString(strings[index++]);
            if (node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return head;
    }
    public static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.parseInt(val));
    }


    /**
     * 通过中序遍历生成序列化的字符串
     * @param head
     * @return
     */
    public static String serialByIn(Node head){
        if(head == null){
            return "#_";
        }
        String l = serialByIn(head.left);
        String res = l + head.value + "_";
        res += serialByIn(head.right);
        return res;
    }


    /**
     * 利用中序遍历的字符串生成二叉树
     * 我写不出来，我裂开了！！！！！！！！！
     * @param inStr
     * @return
     */
    public static Node reconByInString(String inStr){
        return null;
    }


}
