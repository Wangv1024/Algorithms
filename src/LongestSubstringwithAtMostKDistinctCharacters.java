import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by weihengwang on 9/16/16.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k<=0||s.length()==0)
            return 0;
        TreeMap<Integer,Character> tm = new TreeMap<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        int j=-1;
        int len=0;
        for(int i=0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), i);
                tm.put(i, s.charAt(i));
            }
            else{
                int oldk = hm.get(s.charAt(i));
                tm.remove(oldk);
                tm.put(i,s.charAt(i));
                hm.put(s.charAt(i),i);
            }

            if(hm.size()>k){
                int key = tm.firstKey();
                char ch = tm.get(key);
                tm.remove(key);
                hm.remove(ch);
                j=key;
            }
            len = Math.max(len,i-j);
        }
        return len;
    }
    public static void main(String[] args){
        String s = "cccaabbb";
        int k=2;
        System.out.print(lengthOfLongestSubstringKDistinct(s,k));
    }
}
