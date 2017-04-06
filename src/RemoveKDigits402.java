import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by weihengwang on 10/11/16.
 */
public class RemoveKDigits402 {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k)
            return "0";

        Stack<Character> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder strb = new StringBuilder();
        while(!st.isEmpty())
            strb.insert(0,st.pop());
        while(strb.charAt(0)=='0')
            strb.deleteCharAt(0);
        return strb.toString();
    }
}
