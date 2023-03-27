package 基础班.第七节课;

import java.util.PriorityQueue;

/**
 * Author:松鼠
 * Date:2021/7/20 9:26
 */
public class Code06_MedianFinder {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(((o1, o2) -> {return o2 - o1;}));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(((o1, o2) -> {return o1 - o2;}));

        public void modifyTwoHeapsSize() {
            if (maxHeap.size() == minHeap.size() + 2) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() == maxHeap.size() + 2) {
                maxHeap.add(minHeap.poll());
            }
        }

        public void addNumber(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            modifyTwoHeapsSize();
        }

        public Integer getMedian() {
            int maxHeapSize = maxHeap.size();
            int minHeapSize = minHeap.size();
            if (maxHeapSize + minHeapSize == 0) {
                return null;
            }
            Integer maxHeapHead = maxHeap.peek();
            Integer minHeapHead = minHeap.peek();
            if (((maxHeapSize + minHeapSize) & 1) == 0) {
                return (maxHeapHead + minHeapHead) / 2;
            }
            return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
        }


}
