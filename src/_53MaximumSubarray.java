/**
 * Created by weihengwang on 2/28/17.
 */
public class _53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int globmax = nums[0];
        int localmax = nums[0];
        for(int i = 1; i < nums.length; i++){
            localmax = Math.max(localmax + nums[i], nums[i]);
            globmax = Math.max(globmax, localmax);
        }
        return globmax;
    }
}
