import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 9/5/16.
 */
public class CombinationSumIII216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helpper(res,tmp,1,k,n);
        return res;
    }

    private static void helpper(List<List<Integer>> res, List<Integer> tmp, int curnum, int k, int tar){
        if(tar==0 && k==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(tar<=0||k<=0)
            return;
        for(int i=curnum; i<=9; i++){
            tmp.add(i);
            helpper(res,tmp,i+1,k-1,tar-i);
            tmp.remove(tmp.size()-1);
        }

    }
    public static void main(String[] args){
        System.out.print(combinationSum3(3,9));
    }
}
