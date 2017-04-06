import java.util.HashSet;
import java.util.Set;

/**
 * Created by weihengwang on 2/17/17.
 */
public class _3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();
        int leftp = -1;
        int maxlen = 0;
        Set<Character> se = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char curchar = s.charAt(i);
            if(se.contains(curchar)){
                while(se.contains(curchar))
                    se.remove(s.charAt(++leftp));
                se.add(curchar);
            }
            else{
                se.add(curchar);
            }
            maxlen = Math.max(maxlen, i - leftp);
        }
        return maxlen;
    }
}
