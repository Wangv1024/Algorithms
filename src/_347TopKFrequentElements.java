import java.util.*;

/**
 * Created by weihengwang on 8/12/17.
 */
public class _347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        if(k <= 0)
            return res;

        /// use hashMap to get frequence of all number
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.containsKey(num)? mp.get(num) + 1: 1 );
        }

        PriorityQueue<Map.Entry<Integer, Integer>> entryHeap = new PriorityQueue<>(3, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e1.getValue() - e2.getValue();
            }
        });
        // use priorityQueue to extract top k
        // use maintain heap of size k, insert all the element,
        // when we get heap size bigger than k, we discard the top element.
        // move all the element from heap to result list.

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            entryHeap.offer(entry);
            if(entryHeap.size() > k){
                entryHeap.poll();
            }
        }

        while( !entryHeap.isEmpty()){ // res.add(0, pq.poll());
            res.add(0, entryHeap.poll().getKey());
        }
        return res;
    }
}
