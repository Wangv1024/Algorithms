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

    //    beats 79.89%
    public String removeDuplicateLetters2(String s) {
        if(s.length() <= 1)
            return s;

        int[] letterTab = new int[26];
        for(int i = 0; i < s.length(); ++ i){
            letterTab[s.charAt(i) - 'a'] = i;
        }
        boolean[] set = new boolean[26];
        StringBuilder strb = new StringBuilder();
        for(int i = 0; i < s.length(); ++ i){
            char curch = s.charAt(i);
            if(set[curch - 'a'] == true) // set[ curch ] = true; index exceed
                continue;
            while( strb.length() > 0 && strb.charAt(strb.length() - 1) > curch && letterTab[ strb.charAt(strb.length() - 1) - 'a'] > i ){
                set[strb.charAt(strb.length() - 1) - 'a'] = false; // set[ curch ] = true; index exceed
                strb.deleteCharAt(strb.length() - 1);
            }
            strb.append(curch);
            set[curch - 'a'] = true;  // set[ curch ] = true; index exceed
        }
        return strb.toString();
    }
}
