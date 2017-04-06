/**
 * Created by weihengwang on 3/27/17.
 */
public class _33SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int st = 0, end = nums.length - 1;
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[st]){
                if(target < nums[mid] && nums[st] <= target)
                    end = mid - 1;
                else
                    st = mid + 1;
            }
            else{
                if(nums[mid] < target && target <= nums[end]){
                    st = mid + 1;
                }
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
