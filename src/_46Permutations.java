import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 3/2/17.
 */
public class _46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0)
            return res;

        helper(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }

    public void helper(int[] nums, int st, List<Integer> tmp, List<List<Integer>> res){
        if(st >= nums.length) {
            List<Integer> newlist = new LinkedList<>(tmp);
            res.add(newlist);
            return;
        }
//        if(st == nums.length - 1){
//            List<Integer> newlist = new LinkedList<>(tmp);
//            newlist.add(nums[st]);
//            res.add(newlist);
//            return;
//        }

        for(int i = st; i <= nums.length - 1; i++){
            swap(nums, i, st);
            tmp.add(nums[st]);
            helper(nums, st + 1, tmp, res);

            swap(nums, i, st);
            tmp.remove(tmp.size() - 1);
        }
    }

    private void swap(int[] nums, int st, int i){
        int tmp = nums[st];
        nums[st] = nums[i];
        nums[i] = tmp;
    }
}
