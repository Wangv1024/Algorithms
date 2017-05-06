/**
 * Created by weihengwang on 5/2/17.
 */
public class _334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE, large = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= small){
                small = nums[i];
            }
            else if(nums[i] <= mid){
                mid = nums[i];
            }
            else
                return true;
        }
        return false;
    }
}
