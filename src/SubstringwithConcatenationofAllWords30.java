import java.util.*;

/**
 * Created by weihengwang on 9/6/16.
 */
public class SubstringwithConcatenationofAllWords30 {
    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length<1)
            return res;
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        HashMap<String,Integer> diction = new HashMap<>();
        for(String str: words) {
            if(diction.containsKey(str)){
                int times = diction.get(str);
                diction.put(str,++times);
            }
            else
                diction.put(str,1);
        }
        int lastIndx = s.length()-totalLen;
        for(int i=0;i<=lastIndx;i++) {
            matchhelpper(res, diction,i, i, s,wordLen);
        }

        return res;
    }
    private static void matchhelpper(List<Integer> res, HashMap<String,Integer> dict, int st, int stpoint, String s, int wordLen){
        if(dict.isEmpty()) {
            res.add(stpoint);
            return;
        }
        String str = s.substring(st,st+wordLen);
        if(dict.containsKey(str)) {
            int times = dict.get(str);
            if(times>1)
                dict.put(str,times-1);
            else
                dict.remove(str);
            matchhelpper(res, dict,st+wordLen, stpoint, s,wordLen);
            dict.put(str,times);
        }

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length<1)
            return res;
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        HashMap<String,Integer> diction = new HashMap<>();
        for(String str: words) {
            if(diction.containsKey(str)){
                int times = diction.get(str);
                diction.put(str,++times);
            }
            else
                diction.put(str,1);
        }
        int lastIndx = s.length()-totalLen;
        for(int i=0;i<=lastIndx;i++) {
            helpper(res, diction,i, s,wordLen);

        }

        return res;
    }
    private static void helpper(List<Integer> res, HashMap<String,Integer> dict, int st, String s, int wordLen){
        int i = st;
        HashMap<String,Integer> hm = new HashMap<>(dict);
        while(i<s.length()){
            String str = s.substring(i,i+wordLen);
            if(hm.containsKey(str)) {
                int times = hm.get(str);
                if(times>1)
                    hm.put(str,times-1);
                else
                    hm.remove(str);

                if(hm.isEmpty()) {
                    res.add(st);
                    return;
                }
                i=i+wordLen;
            }
            else
                return;
        }

    }

    public static void main(String[] args){
  //      String s ="barfoothefoobarman";
  //      String[] str = {"foo","bar"};

        String s = "wordgoodgoodgoodbestword";
        String[] str = {"word","good","best","good"};
        System.out.print(findSubstring(s,str));
    }
    /*
    "wordgoodgoodgoodbestword"
["word","good","best","good"]
    */
}
