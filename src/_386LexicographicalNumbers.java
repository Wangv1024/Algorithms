import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 2/15/17.
 */
public class _386LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if(n <= 0)
            return res;
        for(int i = 1; i <= 9; i++){
            helper(res, i, n);
        }
        return res;
    }

    public void helper(List<Integer> res, int curnum, int n){
        if(curnum > n)
            return;

        res.add(curnum);
        for(int i = 0; i <= 9; i++){
            helper(res, curnum * 10 + i, n);
            if(curnum * 10 + i > n)
                break;
        }
    }

    public static void main(String[] args){
        _386LexicographicalNumbers obj = new _386LexicographicalNumbers();
        System.out.println(obj.lexicalOrder(125));
    }
}
