import java.util.*;

/**
 * Created by weihengwang on 3/1/17.
 */
public class _126WordLadderII {
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> res = new LinkedList<>();
//        if( !wordList.contains(endWord))
//            return res;
//
//        Set<String> dict = new HashSet<>(wordList);
//        Set<String> explored = new HashSet<>();
//        Set<String> nextExplored = new HashSet<>();
//
//        Set<String> que = new HashSet<>();
//        Set<String> nextQue = new HashSet<>();
//        HashMap<String, List<String>> hm = new HashMap<>();
//        boolean found = false;
//
//        que.add(beginWord);
//        while( !que.isEmpty() || !nextQue.isEmpty()){
//            for(String curstr : que) {
//                if(explored.contains(curstr))
//                    continue;
//                nextExplored.add(curstr);
//
//                List<String> adjlist = getAllAdjWord(dict, curstr, explored);
//                for(String adj : adjlist){
//
//                    if(que.contains(adj))
//                        continue;
//
//                    if(adj.equals(endWord))
//                        found = true;
//
//                    if(hm.containsKey(adj)){
//                        hm.get(adj).add(curstr);
//                    }
//                    else{
//                        List<String> bac = new LinkedList<>();
//                        bac.add(curstr);
//                        hm.put(adj, bac);
//                    }
//                    nextQue.add(adj);
//                }
//
//            }
//
//            if(found)
//                break;
//            que = nextQue;
//            explored = nextExplored;
//            nextExplored = new HashSet<>();
//            nextQue = new HashSet<>();
//        }
//        if(found){
//            List<String> ls =  new LinkedList<String>();
//            ls.add(endWord);
//            reconstruct(res, hm,  ls);
//        }
//
//        return res;
//    }
//    private void reconstruct(List<List<String>> res, HashMap<String, List<String>> hm,  List<String> ls){
//        if( !hm.containsKey(ls.get(0))){
//            res.add(new LinkedList<>(ls));
//            return;
//        }
//        for(String str : hm.get(ls.get(0))){
//            ls.add(0, str);
//            reconstruct(res, hm, ls);
//            ls.remove(0);
//        }
//
//    }
//    private List<String> getAllAdjWord(Set<String> dict, String curstr, Set<String> explored){
//        char[] charr = curstr.toCharArray();
//        List<String> res = new LinkedList<>();
//        for(int i = 0; i < charr.length; i++){
//            char backup = charr[i];
//            for(char c = 'a'; c <= 'z'; c++){
//                if(c == backup)
//                    continue;
//                charr[i] = c;
//                String str = new String(charr);
//                if(dict.contains(str) && ! explored.contains(str))
//                    res.add(str);
//            }
//            charr[i] = backup;
//        }
//        return res;
//    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if( !dict.contains(endWord))
            return new LinkedList<List<String>>();

        dict.remove(endWord);
        dict.remove(beginWord);
        Map<String, List<String>> map = new HashMap<>();
        s1.add(beginWord);  // Forget this two initial condition
        s2.add(endWord);

        helper(s1, s2, map, dict, false);

        List<List<String>> res = new LinkedList<>();
        reconstructList(beginWord, endWord, res, map, new LinkedList<String>());
        return res;
    }
    private boolean helper(Set<String> s1, Set<String> s2, Map<String, List<String>> map, Set<String> dict, boolean backward){
        if(s1.isEmpty() || s2.isEmpty())
            return false;
        if(s1.size() > s2.size())
            return helper(s2, s1, map, dict, !backward);

        Set<String> nextLevel = new HashSet<>();

        boolean found = false;
        for(String str : s1){
            List<String> adjList = getAdjWordFromDict(str, dict, s2);
            for(String adjword : adjList){

                nextLevel.add(adjword);
                if(s2.contains(adjword))
                    found = true;

                String key = backward? adjword : str;
                String val = backward? str : adjword;

                if(map.containsKey(key)){
                    map.get(key).add(val);
                }
                else{
                    List<String> ls = new LinkedList<>();
                    ls.add(val);
                    map.put(key, ls);
                }
            }

        }

        dict.removeAll(nextLevel);

        return found || helper(nextLevel, s2, map, dict, backward);
    }
    private List<String> getAdjWordFromDict(String str, Set<String> dict, Set<String> s2){
        List<String> res = new LinkedList<>();
        char[] charr = str.toCharArray();
        for(int i = 0; i < charr.length; i++){
            char backup = charr[i];
            for(char ch = 'a'; ch <= 'z'; ch++){
                if( backup == ch)
                    continue;
                charr[i] = ch;
                String newstr = new String(charr);
                if(dict.contains(newstr) ||s2.contains(newstr))  //  if(dict.contains(newstr) ) not correct
                    res.add(newstr);
            }
            charr[i] = backup;
        }
        return res;
    }
    private void reconstructList(String beginWord, String endWord, List<List<String>> res, Map<String, List<String>> map, List<String> ls){
        if(beginWord.equals(endWord)){
            ls.add(beginWord);
            res.add(new LinkedList<>(ls));
            ls.remove(ls.size() - 1);
            return;
        }
        if( !map.containsKey(beginWord))
            return;
        ls.add(beginWord);
        for(String str : map.get(beginWord) )
            reconstructList(str, endWord, res, map, ls);

        ls.remove(ls.size() - 1);
    }
}
