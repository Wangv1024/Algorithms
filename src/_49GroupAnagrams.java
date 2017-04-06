import java.util.*;

/**
 * Created by weihengwang on 2/17/17.
 */
public class _49GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> hm = new HashMap<>();

        for(String str: strs){
            char[] curstr = str.toCharArray();
            Arrays.sort(curstr);
            String keystr = new String(curstr);

            if(hm.containsKey(keystr) == false){
                List<String> ls = new ArrayList<>();
                ls.add(str);
                hm.put(keystr, ls);
            }
            else{
                hm.get(keystr).add(str);
            }
        }

        for(List<String> ls : hm.values())
            res.add(ls);
        return res;
    }

    public static void main(String[] args){
        String[] st = {"nat","ant","tan","eat","tea","rob","bro"};
        for(List<String> ls : groupAnagrams(st))
            System.out.println(ls);
    }
}
