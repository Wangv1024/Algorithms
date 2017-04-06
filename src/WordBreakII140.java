import java.util.*;

/**
 * Created by weihengwang on 9/14/16.
 */
public class WordBreakII140 {
    /*
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(wordDict.size()==0||s.length()==0)
            return res;
        StringBuilder strb = new StringBuilder();
        breakhelpper(0,0,s,wordDict,res,strb);
        return res;
    }
    private static void breakhelpper(int st, int cur,String str, Set<String> dict, List<String> res, StringBuilder strb){
        if(st==str.length() && cur==str.length()){
            res.add(strb.toString().trim());
            return;
        }
        if(cur>=str.length())
            return;
        for(int i=st;i<str.length();i++){
            String substr = str.substring(st,i+1);
            if(dict.contains(substr)){
                StringBuilder sb = new StringBuilder(strb);
                sb.append(substr+" ");
                breakhelpper(i+1,i+1,str,dict,res,sb);
            }
        }
    } */
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(wordDict.size()==0||s.length()==0)
            return res;
        List<String> tmpstr = new LinkedList<>();
        int j=0;
        Stack<Integer> istac = new Stack<>();
        Stack<Integer> jstac = new Stack<>();
        /*
        for(int i=0;i<s.length();i++){
            String substr = s.substring(j,i+1);
            if(wordDict.contains(substr)){
                istac.push(i);
                jstac.push(j);
                tmpstr.add(new String(substr));
                System.out.println(tmpstr);
                j=i+1;
            }

            if(j>s.length()-1)
                strcopy(tmpstr,res);
            if(i>=s.length()-1 && !istac.empty()){
        //        strcopy(tmpstr,res);
                tmpstr.remove(tmpstr.size()-1);
                i = istac.pop();
                j = jstac.pop();
            }

        } */
        for(int i=0;i<s.length();i++){
            String substr = s.substring(j,i+1);
            if(wordDict.contains(substr)){
                istac.push(i);
                jstac.push(j);
                tmpstr.add(new String(substr));
         //       System.out.println(tmpstr);
                j=i+1;
            }

            if(j>s.length()-1)
                strcopy(tmpstr,res);
            while(i>=s.length()-1 && !istac.empty()){
        //        strcopy(tmpstr,res);
                tmpstr.remove(tmpstr.size()-1);
                i = istac.pop();
                j = jstac.pop();
            }

        }
        return res;
    }
    private static void strcopy(List<String> str, List<String> res){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.size();i++){
            sb.append(str.get(i)+" ");
        }
        res.add(new String(sb.toString().trim()));
    }
    public static void main(String[] args){
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] ss = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        Set<String> se = new HashSet<>();
        for(String str:ss)
            se.add(str);
        System.out.println("last: "+wordBreak(s,se));
    }
}
