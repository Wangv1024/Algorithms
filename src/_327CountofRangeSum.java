import java.util.TreeMap;

/**
 * Created by weihengwang on 5/24/17.
 */
public class _327CountofRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; ++ i){
            sums[i + 1] = sums[i] + nums[i];
        }

        return countSum(sums, 0, sums.length, lower, upper);
    }
    private int countSum(long[] sums, int st, int end, int lower, int upper){
        //	if(st >= end)   Bugs:  // for st + 1 == end : infinite loop
        if(st + 1 >= end)
            return 0;
        int mid = st + (end - st) / 2;
        int count = countSum(sums, st, mid, lower, upper) + countSum(sums, mid, end, lower, upper);

        int less = mid, more = mid;
        long[] cache = new long[end - st]; // Bugs: in case of sum bigger than Integer.MAX;
        // 	int cachept = st, mergept = mid; // bugs: cachept starts with 0 !!
        int cachept = 0, mergept = mid;

        for(int i = st; i < mid; ++ i){
            // Within current loop, for every current element sums[i], we find sums[less] element that
            // satisfy sums[less] - sums[i] <= lower,  and find sums[more] satisfy sums[more] - sum[i] < upper
            // Given 0 to mid - 1 and mid to end - 1 readily sorted by previous countSum(sums, st, mid, lower, upper)
            // we get count number (more - less) that satisfy the range condition for current sums[i].
            while( less < end && sums[less] - sums[i] < lower ) less ++;
            while( more < end && sums[more] - sums[i] <= upper) more ++;
            count += more - less;

            ////   Merge sort phrase operation:
            ////   Merge all the elements with index range from mid to end - 1 to cache array
            //     After we exhausted element smaller than current sums[i] within mid to end - 1
            //     we append sums[i] into cache[ cachept ]. And done with current iteration.
            while( mergept < end && sums[mergept] < sums[i] ) cache[cachept ++] = sums[mergept ++];
            cache[cachept ++] = sums[i];
        }
        System.arraycopy(cache, 0, sums, st, cachept); // Bugs: cachept is the next value to be inserted.
        // So index 0 to cachept - 1 is the valid range of cache.
        // So we only copy and overwrite that part of element into sums array.
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
