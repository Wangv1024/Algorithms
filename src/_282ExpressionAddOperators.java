import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 5/27/17.
 */
public class _282ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if(num.length() <= 0)
            return res;
        helper(res, "", num, 0, target, 0, 0);
        return res;
    }
    private void helper(List<String> res, String pathsoFar, String num, int st, int target, long evalue, long lastmult){
        if(st >= num.length()){
            if(evalue == target)
                res.add(pathsoFar);
            return;
        }

        for(int exp = st; exp < num.length(); exp++){
            String curstr = num.substring(st, exp + 1);
            if(curstr.length() > 1 && curstr.startsWith("0"))
                break;
            long curval = Long.parseLong(curstr);

            if(st == 0){
                helper(res, curstr, num, exp + 1, target, curval, curval);
            }
            else{
                helper(res, pathsoFar + "+" + curstr, num, exp + 1, target, evalue + curval, curval);

                helper(res, pathsoFar + "-" + curstr, num, exp + 1, target, evalue - curval, - curval);

                helper(res, pathsoFar + "*" + curstr, num, exp + 1, target, evalue - lastmult + lastmult * curval, lastmult * curval);
            }
        }
    }
}
