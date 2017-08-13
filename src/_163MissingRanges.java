import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 6/26/17.
 */
public class _163MissingRanges {
    public List<String> findMissingRanges(int[] nums, int low, int high) {
        List<String> res = new LinkedList<>();
        if(nums.length <= 0){
            res.add(getRange(low, high));
            return res;
        }

        int exp = 0;
        int st = nums.length, end = -1;

        while(exp < nums.length && nums[exp] < low)
            exp ++;
        if(exp < nums.length)
            st = exp;

        while(exp < nums.length && nums[exp] >= low && nums[exp] <= high)
            exp ++;
        end = exp - 1;

        for(int i = st + 1; i <= end; i++){
            if(nums[i - 1] == nums[i])
                continue;
            else if(nums[i - 1] + 1 == nums[i])
                continue;
            else
                res.add( getRange(nums[i - 1] + 1, nums[i] - 1) );
        }
        if(st <= end){
            if(low < nums[st])
                res.add(0, getRange(low, nums[st] - 1));
            if(nums[end] < high)
                res.add(getRange(nums[end] + 1, high));
        }
        return res;
    }
    private String getRange(int st, int end){
        if(st == end)
            return "" + st;
        return "" + st + "->" + end;
    }
}
