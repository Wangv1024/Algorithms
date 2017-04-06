import java.util.*;

/**
 * Created by weihengwang on 9/15/16.
 */
public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t) {
        if(t.length()<=0||s.length()<=0||t.length()>s.length())
            return "";
        TreeMap<Integer,Character> tm = new TreeMap<>();
        HashMap<Character,List<Integer>> hm = new HashMap<>();
        HashMap<Character,Integer> charcount = new HashMap<>();
        Set<Character> se = new HashSet<>();
        for(char ch:t.toCharArray()){
            if(charcount.containsKey(ch))
                charcount.put(ch, charcount.get(ch) + 1);
            else
                charcount.put(ch, 1);
            se.add(ch);
        }

        int count=0;
        String res = s;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(charcount.containsKey(cur)){
                if(!hm.containsKey(cur)){
                    List<Integer> li = new LinkedList<>();
                    li.add(i);
                    hm.put(cur,li);
                    tm.put(i,cur);
                }
                else{
                    List<Integer> past = hm.get(cur);
                    past.add(i);
                    hm.put(cur,past);
                    tm.put(i,cur);
                }

                int num = charcount.get(cur);
                num--;
                if(num==0)
                    se.remove(cur);
                if(num>=0)
                    charcount.put(cur,num);
                else{
                    List<Integer> li = hm.get(cur);
                    int ind = li.remove(0);
                    hm.put(cur,li);
                    tm.remove(ind);
                }
            }

            if(se.isEmpty()) {
                String tmp = s.substring(tm.firstKey(), i + 1);
                res= res.length()>tmp.length()? tmp:res;
            }
        }
        if(se.isEmpty())
            return res;
        else
            return "";
    }
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.print(minWindow("","a"));
    }
}
