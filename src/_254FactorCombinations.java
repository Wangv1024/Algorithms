import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 3/20/17.
 */
public class _254FactorCombinations {
//    public List<List<Integer>> getFactors(int n) {
//        List<List<Integer>> res = new ArrayList<>();
//        if(n <= 1)
//            return res;
//        helper(res, new ArrayList<Integer>(), n, 2);
//        return res;
//    }
//
//    public void helper(List<List<Integer>> res, List<Integer> tmp, int n, int st){
//        if(n <= 1){
//            if(tmp.size() > 1)
//                res.add(new ArrayList<>(tmp));
//            return;
//        }
//
//        for(int i = st; i <= n; i++){
//            if(n % i == 0){
//                tmp.add(i);
//                helper(res, tmp, n / i, i);
//                tmp.remove(tmp.size() - 1);
//            }
//        }
//    }
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 1)
            return res;
        helper(res, n, new ArrayList<Integer>(), 2);
        return res;
    }
    public void helper(List<List<Integer>> res, int n, List<Integer> tmp, int factor){
        if(n == 1){
            if(tmp.size() > 2)
                res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = factor; i <= n; i++){
            if(n % i == 0 && n / i >= 1){
                tmp.add(i);
                helper(res, n / i, tmp, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
