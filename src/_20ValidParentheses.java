import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 2/16/17.
 */
public class _20ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        Deque<Character> st = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char curcha = s.charAt(i);
            if(curcha == '(' || curcha == '{' || curcha == '[')
                st.push(curcha);
            else{
                if(st.isEmpty() == true)
                    return false;

                if(st.peek() == '{' && curcha == '}'
                        || st.peek() == '[' && curcha == ']'
                        || st.peek() == '(' && curcha == ')')
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
