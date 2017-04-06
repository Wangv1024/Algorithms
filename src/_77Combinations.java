import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 3/29/17.
 */
public class _77Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k <= 0)
            return res;
        helper(res, n, k, 1, new ArrayList<Integer>());
        return res;
    }
    public static void helper(List<List<Integer>> res, int range, int remain, int st, List<Integer> ls){
        if(remain <= 0){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = st; i <= range; i ++){
            ls.add(i);
            helper(res, range, remain - 1, i + 1, ls);
            ls.remove(ls.size() - 1);
        }
    }
    public static void main(String[] args){
        System.out.println(combine(6, 3));
    }
}
