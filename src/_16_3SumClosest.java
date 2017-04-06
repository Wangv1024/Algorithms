import java.util.Arrays;

/**
 * Created by weihengwang on 3/19/17.
 */
public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            while(j < k){
                if(j - 1 > i && nums[j] == nums[j - 1]){
                    j++; continue;
                }
                if(k + 1 <= nums.length - 1 && nums[k] == nums[k + 1]){
                    k--; continue;
                }
                int sum = nums[i] + nums[k] + nums[j];
                if(sum == target)
                    return sum;
                if(Math.abs(closest - target) > Math.abs(sum - target))
                    closest = sum;

                if(sum < target)
                    j++;
                else
                    k--;
            }
        }
        return closest;
    }
}
