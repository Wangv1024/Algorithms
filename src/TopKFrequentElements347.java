import java.util.*;

/**
 * Created by weihengwang on 9/10/16.
 */
public class TopKFrequentElements347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        if(nums.length<1||k<1)
            return res;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                int tmp = hm.get(nums[i]);
                hm.put(nums[i],tmp+1);
            }
            else
                hm.put(nums[i],1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(k,new CompareRule());
        for(Map.Entry en:hm.entrySet()){
            pq.add(en);
            if(pq.size()>k)
                pq.poll();
        }
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,3};
        System.out.println(topKFrequent(arr,2));
    }
}

class CompareRule implements Comparator<Map.Entry<Integer,Integer>>{
    public int compare(Map.Entry<Integer,Integer> en1,Map.Entry<Integer,Integer> en2){
        return en1.getValue()-en2.getValue();
    }

}