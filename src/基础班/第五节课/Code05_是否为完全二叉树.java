package 基础班.第五节课;

import java.util.LinkedList;

/**
 * Author:松鼠
 * Date:2021/6/27 11:44
 */
public class Code05_是否为完全二叉树 {
    public static void main(String[] args) {

    }



    public static boolean isCBT(Node head){
        LinkedList<Node> queue = new LinkedList<>();
        boolean flag = false; //代表一个开关，如果这个变为true，就表示从此时往后的结点都为叶子节点
        queue.add(head);
        while (!queue.isEmpty()){
            head = queue.remove();
            Node l = head.left;
            Node r = head.right;
            //这个判断条件很重要  要看懂 学到精髓
            //情况一：如果一个节点有右孩子，但是没有左孩子，那直接false
            //情况二：如果所有结点都不满足情况一，那么flag就变成true，
            // 且后面遍历的结点都为叶子节点（就是说都没有左孩子和右孩子）
            if( (flag && (l != null || r != null))  ||  (l == null && r != null) ){
                return false;
            }
            if(l != null ){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }else {
                //此时r为空，l为不为空没所谓，因为只要r为空给，
                // 且前面的判断没有拦住，就说明这个head开始，后面就都必须是叶子节点
                flag = true;
            }
        }
        return true;
    }




}
