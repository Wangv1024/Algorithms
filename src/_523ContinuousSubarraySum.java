import java.util.HashSet;
import java.util.Set;

/**
 * Created by weihengwang on 4/22/17.
 */
public class _523ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length <= 1)
            return false;
        if(k == -1 || k == 1)
            return true;

        for(int i = 0; i < nums.length - 1; i++)
            if(nums[i] == nums[i + 1] && nums[i] == 0)
                return true;
        if( k == 0 )
            return false;

        k = Math.abs(k);
        Set<Integer> sumset = new HashSet<>();
        int cursum = nums[0];
        for(int i = 1; i < nums.length; i++){
            cursum = cursum + nums[i];

            for(int multi = 1; multi * k <= cursum; multi++ ){
                int multiple = multi * k;  // infinite loop if k == 0 or k < 0
                if(sumset.contains(cursum - multiple) || cursum == multiple)
                    return true;
                if(multiple == 0)
                    break;
            }
            sumset.add(cursum - nums[i]);
        }
        return false;
    }
    public static boolean checkSubarraySum2(int[] nums, int k) {
        // Since the size of subarray is at least 2.
        if (nums.length <= 1) return false;
        // Two continuous "0" will form a subarray which has sum = 0. 0 * k == 0 will always be true.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }

        // At this point, k can't be "0" any longer.
        if (k == 0) return false;
        // Let's only check positive k. Because if there is a n makes n * k = sum, it is always true -n * -k = sum.
        if (k < 0) k = -k;

        Set<Integer> sums = new HashSet<>();
        int sum = 0;
        sums.add(0);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i > 0) {
                // Validate from the biggest possible n * k to k
                for (int j = (sum / k) * k; j >= k; j -= k) {
                    if (sums.contains(sum - j)) return true;
                }
            }

            sums.add(sum);
        }

        return false;
    }

    public static void main(String[] args){
        int[] input = new int[]{1,2};
        System.out.println(checkSubarraySum2(input, 2));
    }
}
