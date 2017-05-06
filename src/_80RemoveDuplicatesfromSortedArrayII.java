/**
 * Created by weihengwang on 5/5/17.
 */
public class _80RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2)
            return nums.length;
        int insp = -1;
        int st = 0;
        while(st < nums.length){
            int exp = st;
            while(exp < nums.length && nums[exp] == nums[st])
                exp++;
            int blocklen = exp - st;
            blocklen = Math.min(2, blocklen);

            while(blocklen-- > 0)
                nums[ ++insp ] = nums[st ++];

            st = exp;
        }
        return insp + 1;
    }
}
