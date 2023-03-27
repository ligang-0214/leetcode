package 提升班.第一节课_哈希函数和并查集;

import java.util.HashMap;
import java.util.Random;

/**
 * Author:松鼠
 * Date:2021/7/26 15:48
 */
public class Code02_RandomPool {
    public static class Pool<K>{
        HashMap<K,Integer> keyIndexMap;
        HashMap<Integer,K> indexKeyMap;
        int index;

        public Pool(){
            this.index = 0;
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
        }


        public void insert(K key){
            if(!keyIndexMap.containsKey(key)){
                keyIndexMap.put(key,index);
                indexKeyMap.put(index++,key);
            }
        }

        public void delete(K key){
            if(!keyIndexMap.containsKey(key)){
                return;
            }
            Integer deleteIndex = keyIndexMap.get(key);
            K lastKey = indexKeyMap.get(--index);
            keyIndexMap.put(lastKey,deleteIndex);
            indexKeyMap.put(deleteIndex,lastKey);
            keyIndexMap.remove(key);
            indexKeyMap.remove(index);
        }

        public K getRandom() {
            if (index == 0) {
                return null;
            }
            int randomIndex = new Random().nextInt(index); // 0 ~ index -1
            return indexKeyMap.get(randomIndex);
        }



    }
}
