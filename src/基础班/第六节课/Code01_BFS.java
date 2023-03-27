package 基础班.第六节课;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:松鼠
 * Date:2021/7/5 15:07
 */
@SuppressWarnings("all")
public class Code01_BFS {

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        //可以用数组来替代哈希表  因为会稍微快一点点
        HashSet<Node> map = new HashSet<>(); //保存遍历过的node
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.value);//这里其实就是以后做题时需要处理的部分
            for (Node next : cur.nexts) {
                //1、为了防止把自己成环的node也添加到队列中  2、看这个结点是否遍历过了
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }


    public static void bfsPractice(Node node){
        if(node == null){
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node>  selectedNode = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node remove = queue.remove();
            System.out.println(remove.value);
            for (Node next : remove.nexts ) {
                if(!selectedNode.contains(next)){
                    queue.add(next);
                    selectedNode.add(next);
                }

            }
        }
    }
}
