import java.util.TreeMap;

/**
 * Created by weihengwang on 5/24/17.
 */
public class _327CountofRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length <= 0)
            return 0;
        long[] sum = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];

        return getCountSum(sum, 0, sum.length, lower, upper);
    }
    private int getCountSum(long[] sum, int st, int end, int low, int up){
        if(end - st <= 1)
            return 0;
        int mid = st + (end - st) / 2;
        int count = getCountSum(sum, st, mid, low, up) + getCountSum(sum, mid, end, low, up);

        int less = mid, more = mid;
        long[] cache = new long[end - st];
        int cachep = 0, rmerge = mid;
        for(int i = st; i < mid; i ++){
            while(less < end && sum[less] - sum[i] < low) less++;
            while(more < end && sum[more] - sum[i] <= up) more++;
            while(rmerge < end && sum[rmerge] < sum[i] ) cache[cachep++] = sum[rmerge++];

            cache[cachep++] = sum[i];
            count += more - less;
        }
        System.arraycopy(cache, 0, sum, st, cachep);
        return count;
    }

    public int countRangeSum1(int[] nums, int lower, int upper) {
        if(nums.length <= 0)
            return 0;
        int count = 0;

        TreeMap<Long, Integer> tmap = new TreeMap<>();  // TreeSet can not contains duplicate

        long cursum = 0;
        for(int i = 0; i < nums.length; i++){
            cursum = nums[i] + cursum;

            if(cursum >= lower && cursum <= upper)
                count ++;

            Long ceil = tmap.ceilingKey(cursum - upper);
            while(ceil != null && ceil <= cursum - lower){
                count = count + tmap.get(ceil);  // Bugs TreeSet can not handle duplication
                ceil = tmap.higherKey(ceil);
            }

            tmap.put(cursum, tmap.containsKey(cursum)? tmap.get(cursum) + 1 : 1);
        }
        return count;
    }
}
