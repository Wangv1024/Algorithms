import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by weihengwang on 4/4/17.
 */
public class _316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s.length() <= 1)
            return s;
        Deque<Character> st = new LinkedList<>();
        Set<Character> se = new HashSet<>();
        int[] tab = new int[26];
        for(int i = 0; i < s.length(); i++){
            char curch = s.charAt(i);
            tab[curch - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            char curch = s.charAt(i);
            tab[curch - 'a'] --;
            if(se.contains(curch))
                continue;
            while( !st.isEmpty() && st.peek() > curch && tab[st.peek() - 'a'] > 0)
                se.remove(st.pop());
            st.push(curch);
            se.add(curch);
        }
        StringBuilder strb = new StringBuilder();
        while( !st.isEmpty())
            strb.append(st.pop());
        return strb.reverse().toString();
    }
}
