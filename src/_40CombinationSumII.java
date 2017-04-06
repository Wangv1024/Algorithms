import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weihengwang on 1/20/17.
 */
public class _40CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        csumhelper(candidates, target, res, new ArrayList<Integer>(), 0);

        return res;
    }

    private static void csumhelper(int[] candid, int target, List<List<Integer>> res, List<Integer> tmp, int stindx){
        if(target < 0 )
            return;
        if(target == 0){
            List<Integer> l1 = new ArrayList<>(tmp);
            res.add(l1);
        }
        for(int i = stindx; i < candid.length; i++) {
            if(i > stindx && candid[i] == candid[i - 1] )
                continue;
            tmp.add(candid[i]);
            csumhelper(candid, target - candid[i], res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args){
        int[]  candi = {2,2,2};
        int target = 4;
        List<List<Integer>> res = combinationSum2(candi, target);
        for(List li: res)
            System.out.println(li);
    }
}
