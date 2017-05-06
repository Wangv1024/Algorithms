/**
 * Created by weihengwang on 5/3/17.
 */
public class _81SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length <= 0)
            return false;
        int st = 0, end = nums.length - 1;
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(nums[mid] == target)
                return true;

            if(nums[mid] == nums[end])
                end --;
            else if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end])
                    return binarySearch(nums, mid, end, target);
                else
                    end = mid - 1;
            }
            else{  // nums[mid] > nums[end]
                if(nums[st] <= target && target < nums[mid])
                    return binarySearch(nums, st, mid, target);
                else
                    st = mid + 1;
            }
        }
        return false;
    }
    private boolean binarySearch(int[] nums, int st, int end, int target){
        while(st <= end){
            int mid = st + ( end - st ) / 2;
            if(nums[mid] == target)
                return true;

            if(nums[mid] < target)
                st = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
