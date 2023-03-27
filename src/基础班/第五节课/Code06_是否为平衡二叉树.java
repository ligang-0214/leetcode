package 基础班.第五节课;

/**
 * Author:松鼠
 * Date:2021/6/27 19:54
 */
@SuppressWarnings("all")
public class Code06_是否为平衡二叉树 {
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
        head.right.right.right.right = new Node(12);
        head.right.right.right.right.right = new Node(13);
        System.out.println(isBalanceTree(head));

    }

    public static boolean isBalanceTree(Node head){
        return process(head).isBalance;
    }

    /**
     * 返回类型，需要设置成什么就设置成什么
     */
    public static class ReturnType{
        public boolean isBalance;
        public int height;
        public ReturnType(boolean isBalance,int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    /**
     * 假设拿到某个结点，可以利用当前节点的左孩子、右孩子的信息，构造出当前节点的信息
     * 那么这个递归就可以连接起来，这个就是大体的套路
     * @param x
     * @return
     */
    private static ReturnType process(Node x) {
        //base case  这个设置也比较有讲究，要多些才有感觉，主要还是根据业务来设计
        if (x == null){
            return new ReturnType(true,0);
        }
        ReturnType l = process(x.left);
        ReturnType r = process(x.right);
        int height = Math.max(l.height,r.height) + 1 ;
        if (l.isBalance == false || r.isBalance == false || Math.abs(l.height - r.height) > 1){
            return new ReturnType(false,height);
        }
        return new ReturnType(true,height);
    }


}
