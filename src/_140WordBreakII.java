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

    public List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<Integer>[] backtrack = (ArrayList<Integer>[]) new ArrayList[s.length() + 1];

        boolean[] explored = new boolean[s.length() + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);

        while( !que.isEmpty()){
            int stindex = que.poll();
            if(explored[stindex] == true)
                continue;

            for(int i = stindex + 1; i <= s.length(); i++){
                if(dict.contains(s.substring(stindex, i))){
                    if(backtrack[i] == null)
                        backtrack[i] = new ArrayList<>();
                    backtrack[i].add(stindex);

                    que.offer(i);
                }
            }

            explored[stindex] = true;
        }

        List<String> res = new LinkedList<>();
        recovery(backtrack, s.length(), res, "", s);
        return res;
    }
    private void recovery(List<Integer>[] back, int curindex, List<String> res, String tmp, String s){
        if(back[curindex] == null || curindex == 0){
            if(tmp.length() > 0)
                res.add(tmp);
            return;
        }

        for(int preindex : back[curindex]){
            String str = s.substring(preindex, curindex);
            recovery(back, preindex, res, str + ( tmp.length() > 0 ? " " : "" ) + tmp, s);
        }
    }
}
