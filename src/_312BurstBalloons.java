import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by weihengwang on 5/16/17.
 */
public class _312BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        for(int i = 1; i <= nums.length; i++)
            arr[i] = nums[i - 1];

        arr[0] = 1; arr[arr.length - 1] = 1;
        int[][] cache = new int[nums.length + 2][nums.length + 2];

        return getMaxCoins(arr, cache, 0, arr.length - 1);
    }
    private int getMaxCoins(int[] arr, int[][] cache, int st, int end){
        if(st + 1 >= end)
            return 0;

        if(cache[st][end] > 0)
            return cache[st][end];
        int max = Integer.MIN_VALUE;
        for(int tr = st + 1; tr <= end - 1; tr ++){
            max = Math.max(max, arr[tr] * arr[st] * arr[end]
                    + getMaxCoins(arr, cache, st, tr) + getMaxCoins(arr, cache, tr, end) );

        }
        cache[st][end] = max;
        return max;
    }


    public int maxCoins2(int[] nums) {
        if(nums.length <= 0)
            return 0;
        List<Integer> templ = new ArrayList<>();
        for(int num : nums)
            templ.add(num);
        templ.add(1);
        templ.add(0, 1);

        return burstHelper(templ, new HashMap<List<Integer>, Integer>());
    }


    private int burstHelper(List<Integer> templ, HashMap<List<Integer>, Integer> cache){
        if(templ.size() <= 2)
            return 0;
        List<Integer> newlist = new ArrayList<>(templ);
         if( cache.containsKey(newlist) )
             return cache.get(newlist);

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < templ.size() - 1; i++){
            int profit = templ.get(i) * templ.get(i - 1)  * templ.get(i + 1);
            int backup = templ.remove(i);
            max = Math.max(max, burstHelper(templ, cache) + profit);
            templ.add(i, backup);
        }
        cache.put(newlist, max);
        return max;
    }
    private String asString(List<Integer> ls){
        StringBuilder strb = new StringBuilder();
        for(int num : ls)
            strb.append("" + num + " ");
        return strb.toString().trim();
    }

    /////////    Method 2

    public int maxCoins3(int[] nums) {
        if(nums.length <= 1)
            return nums.length == 0 ? 0 : nums[0];

        int[] newnums = new int[ nums.length + 2 ];
        int[][] tab = new int[ newnums.length ][ newnums.length ];
        for(int i = 0; i < nums.length; ++ i){
            newnums[i + 1] = nums[i];
        }
        newnums[0] = 1; newnums[ newnums.length - 1 ] = 1;

        for(int len = 1; len <= nums.length; ++ len){
            for(int st = 1; st + len - 1 < newnums.length - 1; ++ st){
                int end = st + len - 1;

                for(int i = st; i <= end; ++ i){
                    tab[st][end] = Math.max( tab[st][end],
                            tab[st][i - 1] + tab[i + 1][end] + newnums[i] * newnums[st - 1] * newnums[end + 1] );
                }
            }
        }
        return tab[1][ newnums.length - 2 ];
    }



    public static void main(String[] args){
        _312BurstBalloons obj = new _312BurstBalloons();
        int[] nums = {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5};
        System.out.println(obj.maxCoins(nums));
    }
}
