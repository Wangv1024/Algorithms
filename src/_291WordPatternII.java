import java.util.*;
/**
 * Created by weihengwang on 5/8/17.
 */
public class _291WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        return isMatch(pattern, str, new HashMap<Character, String>(), new HashSet<String>());
    }
    private boolean isMatch(String pattern, String string, HashMap<Character, String> hm, HashSet<String> set){
        if(pattern.length() == 0 && string.length() == 0)
            return true;
        if(pattern.length() == 0 || string.length() == 0)
            return false;

        if(hm.containsKey(pattern.charAt(0))){
            String getstr = hm.get(pattern.charAt(0));
            if(string.startsWith(getstr) && isMatch(pattern.substring(1), string.substring(getstr.length()), hm, set))
                return true;
            else
                return false;
        }
        for(int i = 0; i < string.length(); i++){
            String str = string.substring(0, i + 1);
            if(set.contains(str))
                continue;

            hm.put(pattern.charAt(0), str);
            set.add(str);
            if(isMatch(pattern.substring(1), string.substring(str.length()), hm, set))
                return true;

            hm.remove(pattern.charAt(0));
            set.remove(str);
        }
        return false;
    }
}
