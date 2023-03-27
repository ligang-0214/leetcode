package 基础班.第五节课;

/**
 * Author:松鼠
 * Date:2021/6/28 14:14
 */
@SuppressWarnings("all")
public class Code06_二叉树的动态规划套路_非常好 {

    /**
     * 使用套路解答 是否为平衡二叉树
     */
    public static boolean isBalanceTree(Node head){
        return process1(head).isBalance;
    }
    /**
     * 返回类型，需要设置成什么就设置成什么
     */
    public static class ReturnType1{
        public boolean isBalance;
        public int height;
        public ReturnType1(boolean isBalance,int height){
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
    private static ReturnType1 process1(Node x) {
        //base case  这个设置也比较有讲究，要多些才有感觉，主要还是根据业务来设计
        if (x == null){
            return new ReturnType1(true,0);
        }
        ReturnType1 l = process1(x.left);
        ReturnType1 r = process1(x.right);
        int height = Math.max(l.height,r.height) + 1 ;
        if (l.isBalance == false || r.isBalance == false || Math.abs(l.height - r.height) > 1){
            return new ReturnType1(false,height);
        }
        return new ReturnType1(true,height);
    }


    /**
     * 使用套路解答  是否为二叉搜索树
     */
    public static boolean isBST(Node head){
        return process2(head).isBST;
    }

    /**
     * 判断是否为二叉搜索树的返回类型
     * 因为需要左孩子的最大值，右孩子的最小值，所以返回类型为所需要信息的并集
     */
    public static class ReturnType2 {
        boolean isBST;
        int min;
        int max;
        public ReturnType2(boolean is, int mi, int ma) {
            isBST = is;
            min = mi;
            max = ma;
        }
    }

    private static ReturnType2 process2(Node x) {
        //因为这里为空的时候，返回值中的min和max不好设置，所以就留给调用者来处理
        if(x == null){
            return null;
        }
        ReturnType2 l = process2(x.left);
        ReturnType2 r = process2(x.right);
        int min = x.value;
        int max = x.value;
        if (l != null){
            min = Math.min(min,l.min);
            max = Math.max(max,l.max);
        }
        if(r != null){
            min = Math.min(min,r.min);
            max = Math.max(max,r.max);
        }
        //这个判断部分非常重要，具体情况具体分析，一定不能遗漏细节
        //判断是否为二叉搜索树就比较麻烦，还需要考虑左右子树是否为null，可以自自己好好想想判断条件
        boolean isBST = true;
        if (l != null && (l.isBST == false || x.value <= l.max)){
            isBST = false;
        }
        if (r != null && (r.isBST == false || x.value >= r.min)){
            isBST = false;
        }
        return  new ReturnType2(isBST,min,max);
    }


    /**
     * 使用套路解答  是否为满二叉树
     * 2^层数 - 1 = 节点数
     *
     * @param head
     * @return
     */
    public static boolean isFullTree(Node head){
        if (head == null){
            return true;
        }

        ReturnType3 data = process3(head);
        return  data.nodes == (1 << data.height - 1);
    }

    public  static class ReturnType3{
        int nodes;
        int height;
        public ReturnType3(int nodes,int height){
            this.height = height;
            this.nodes = nodes;
        }
    }

    private static ReturnType3 process3(Node x) {
        if(x == null){
            return new ReturnType3(0,0);
        }

        ReturnType3 l = process3(x.left);
        ReturnType3 r = process3(x.right);
        int nodes = l.nodes + r.nodes + 1;
        int height = Math.max(l.height,r.height) + 1;
        return new ReturnType3(nodes,height);
    }

}
