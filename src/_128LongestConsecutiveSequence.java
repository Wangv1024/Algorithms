import java.util.HashMap;

/**
 * Created by weihengwang on 5/28/17.
 */
public class _128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int[] rank = new int[nums.length];
        int[] parent = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
        int max = 1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            if(hm.containsKey(num))
                continue;
            if(hm.containsKey(num - 1) && hm.containsKey(num + 1)){
  //              hm.put(num, i);
                unionthis(hm.get(num + 1), i, parent, rank);
                unionthis(hm.get(num - 1), i, parent, rank);
            }
            else if(hm.containsKey(num - 1))
                unionthis(i, hm.get(num - 1), parent, rank);
            else if(hm.containsKey(num + 1))
                unionthis(i, hm.get(num + 1), parent, rank);

            hm.put(num, i);

            max = Math.max(max, rank[parent[i]]);
        }

        return max;
    }
    private void unionthis(int id1, int id2, int[] parent, int[] rank){
        int par1 = findparent(id1, parent);
        int par2 = findparent(id2, parent);

        if(par1 == par2)
            return;
        if(rank[par1] > rank[par2]){
            parent[par2] = par1;
        }
        else
            parent[par1] = par2;

        int total = rank[par1] + rank[par2];
        rank[par1] = total;
        rank[par2] = total;

    }
    private int findparent(int id, int[] parent){
        while(parent[id] != parent[ parent[id] ])
            parent[id] = parent[ parent[id] ];
        return parent[id];
    }
}
