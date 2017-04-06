import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 3/28/17.
 */
public class _39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length <= 0)
            return res;
        helper(res, target, 0, new ArrayList<Integer>(), candidates);
        return res;
    }

    public void helper(List<List<Integer>> res, int target, int st, List<Integer> ls, int[] candid){
        if(target < 0)
            return;
        if(target == 0){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = st; i < candid.length; i++){
            ls.add(candid[i]);
            helper(res, target - candid[i], i, ls, candid);
            ls.remove(ls.size() - 1);
        }
    }
}
