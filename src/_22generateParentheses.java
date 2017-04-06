import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by weihengwang on 1/26/17.
 */
public class _22generateParentheses {
    public static List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        StringBuilder strb = new StringBuilder();
        int parenthesisnum = 0;

        helper(res, strb, parenthesisnum, n);
        return res;
    }
    public static void helper(List<String> res, StringBuilder strb, int parenthesisnum, int n){
        if(parenthesisnum == 0 && strb.length() == 2 * n) {
            res.add(strb.toString());
            return;
        }
        if(strb.length() > n * 2 || parenthesisnum > n)
            return;
        String[] parenthesis = { "(", ")" };
        for(String str : parenthesis){
            if(parenthesisnum == 0 && str.equals(")"))
                continue;

            int tmp = parenthesisnum;
            if(str.equals(")"))
                parenthesisnum --;
            else
                parenthesisnum ++;
            strb.append(str);

            helper(res, strb, parenthesisnum, n);
            strb.deleteCharAt(strb.length() - 1);
            parenthesisnum = tmp;
        }

    }
    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }
}
