/**
 * Created by weihengwang on 4/29/17.
 */
public class _31NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 0)
            return ;
        int end = nums.length - 1;
        for( ; end >= 0; end --){
            if(end > 0 && nums[end - 1] < nums[end])
                break;
        }
        if(end > 0){
            int swapindex = end;
            while(swapindex < nums.length && nums[swapindex] > nums[end - 1]){
                swapindex ++;
            }
            swapindex --;
            swap(nums, swapindex, end - 1);
        }
        reverse(nums, end, nums.length - 1);
    }
    private void swap(int[] nums, int in1, int in2){
        nums[in1] = nums[in1] ^ nums[in2];
        nums[in2] = nums[in1] ^ nums[in2];
        nums[in1] = nums[in1] ^ nums[in2];
    }
    private void reverse(int[] nums, int st, int end){
        while(st < end)
            swap(nums, st, end);
    }
}
