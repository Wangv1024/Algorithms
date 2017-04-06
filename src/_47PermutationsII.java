import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 3/2/17.
 */
public class _47PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length <= 0)
            return res;

        Arrays.sort(nums);
        int[] used = new int[nums.length];
        helper(nums, res, new LinkedList<Integer>(), 0, used);
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int st, int[] used){
        if(st >= nums.length){
            List<Integer> ret = new LinkedList<>(tmp);
            res.add(ret);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1 || i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0)
                continue;
            used[i] = 1;
            tmp.add(nums[i]);
            helper(nums, res, tmp, st + 1, used);
            tmp.remove(tmp.size() - 1);
            used[i] = 0;
        }
    }

}
