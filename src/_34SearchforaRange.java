/**
 * Created by weihengwang on 3/27/17.
 */
public class _34SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};
        if(nums.length == 1)
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        int st = searchgreatequal(nums, target);
        if(nums[st] != target)
            return new int[]{-1, -1};
        int end = searchgreatequal(nums, target + 1);
        if(nums[end] == target)
            end++;
        return new int[] {st, end - 1};
    }
    public int searchgreatequal(int[] nums, int target){
        int st = 0, end = nums.length - 1;
        while(st < end){
            int mid = st + (end - st) / 2;
            if(nums[mid] < target)
                st = mid + 1;
            else
                end = mid;
        }
        return end;
    }
}
