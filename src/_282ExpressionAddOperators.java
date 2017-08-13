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

/*

    char[] tab = new char[]{'+', '-', '*'};
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if(num.length() == 0)
            return res;

        StringBuilder strb = new StringBuilder();
        strb.append(num.charAt(0));
        generateExpression(res, num, strb, 1, target);
        return res;
    }
    private void generateExpression(List<String> res, String s, StringBuilder strb, int st, int target){
        if(st >= s.length()){
            Integer val = evaluate(strb.toString());
            if(val != null && val == target)
                res.add(strb.toString());
            return;
        }

        for(char ch : tab){
            strb.append(ch);
            strb.append(s.charAt(st));
            generateExpression(res, s, strb, st + 1, target);

            strb.deleteCharAt(strb.length() - 1);
            strb.deleteCharAt(strb.length() - 1);
        }

        strb.append(s.charAt(st));
        generateExpression(res, s, strb, st + 1, target);
        strb.deleteCharAt(strb.length() - 1);
    }
    private Integer evaluate(String str){
        Deque<Long> st = new LinkedList<>();
        char sign = '+';
        String num = "";
        for(int i = 0; i < str.length(); i++){
            char curch = str.charAt(i);
            if( Character.isDigit( curch ) )
                num = num + curch ;

            if( !Character.isDigit( curch ) || i == str.length() - 1){
                if(num.length() > 1 && num.startsWith("0")  )
                    return null;
                long number = Long.parseLong(num);
                if(number > 2147483647 || number < -2147483648)
                    return null;

                if(sign == '+')
                    st.push(number);
                else if(sign == '-')
                    st.push( - number);
                else if(sign == '*')
                    st.push( st.pop() * number );

                num = "";
                sign = curch;
            }
        }
        long total = 0;
        while( !st.isEmpty() )
            total = total + st.pop();
        if(total > 2147483647 || total < -2147483648)
            return null;

        return new Integer( (int) total);
    }
    */
}
