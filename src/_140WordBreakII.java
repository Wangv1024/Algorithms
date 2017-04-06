import java.util.*;

/**
 * Created by weihengwang on 4/2/17.
 */
public class _140WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for(String str : wordDict)
            dict.add(str);

        return getBreakList(s, dict, new HashMap<String, List<String>>());
    }
    public List<String> getBreakList(String s, Set<String> di, Map<String, List<String>> hm){
        if(s.length() <= 0){
            List<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        }

        if(hm.containsKey(s))
            return hm.get(s);

        List<String> newres = new ArrayList<>();
        for(String str : di){
            if(s.startsWith(str)){
                List<String> re = getBreakList(s.substring(str.length()), di, hm);

                for(String eachstr : re){
                    newres.add(str + (eachstr.length() == 0 ? "" : " " + eachstr ));
                }
            }
        }

        hm.put(s, newres);
        return newres;
    }
}
