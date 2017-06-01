import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 5/31/17.
 */
public class _224BasicCalculator {
    public int calculate(String s) {
        int result = 0;
        int curnum = 0;
        int sign = 1;
        Deque<Integer> st = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch))
                curnum = curnum * 10 + ch - '0';
            else if(ch == '+' || ch == '-'){
                result += curnum * sign;

                curnum = 0;
                sign = ch =='+'? 1 : -1;
            }
            else if(ch == '('){
                st.push(result);
                st.push(sign);

                sign = 1;
                result = 0;
            }
            else if(ch == ')'){
                result += curnum * sign;
                result = result * st.pop();

                result += st.pop();

                sign = 1;
                curnum = 0;
            }

            if(i == s.length() - 1)
                result += sign * curnum;
        }
        return result;
    }

    public static int calculate2(String s) {
        Deque<Integer> st = new LinkedList<>();

        char sign = '+';
        int curnum = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                curnum = curnum * 10 + ch - '0';
            }

            if(ch == '('){
                int closeindex = getmatchedparenth(s, i);
                curnum = calculate2(s.substring(i + 1, closeindex));
                i = closeindex;
            }

            if(ch == '+' || ch == '-' ||ch == '*' || ch == '/' ||
                    i >= s.length() - 1)
            {

                if (sign == '+')
                    st.push(curnum);
                else if (sign == '-')
                    st.push( - curnum);
                else if (sign == '*')
                    st.push(st.pop() * curnum);
                else if (sign == '/')
                    st.push(st.pop() / curnum);

                sign = ch == '(' ? sign : ch;
                curnum = 0;

            }

        }
        int res = 0;
        for(int num : st)
            res += num;
        return res;
    }
    private static int getmatchedparenth(String s, int st){
        int count = 0;
        for(int exp = st; exp < s.length(); exp++){
            if(s.charAt(exp) == '(')
                count++;
            else if(s.charAt(exp) == ')')
                count--;

            if(count == 0)
                return exp;
        }
        return -1;
    }

    public static void main(String[] args){
 //       String str = "(1 + 2 * (4 + 3 * 2 - 1)) * (1 * 2)";
        String str = "(1 + 2) * (2 + 3) + 2 * 2";
        System.out.println(calculate2(str));
    }
}
