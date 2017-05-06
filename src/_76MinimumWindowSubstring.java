/**
 * Created by weihengwang on 4/24/17.
 */
public class _76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        char[] counttab = new char[256];
        for(char c : t.toCharArray())
            counttab[c]++;
        int total = 0;
        for(int i = 0; i < counttab.length; i++)
            if(counttab[i] != 0)
                total++;

        char[] tab = new char[256];
        int tail = 0;
        int count = 0;
        int charnum = 0;
        String res = null;
        boolean found = false;
        for(int i = 0; i < s.length(); i++){
            char curchar = s.charAt(i);
            if(counttab[curchar] == 0) // curchar is not char contained in t string
                continue;

            tab[curchar]++;
            if(found || containsT(tab, counttab)){
                found = true;
                while(tab[ s.charAt(tail) ] > counttab[ s.charAt(tail) ] || counttab[s.charAt(tail)] == 0){
                    if(counttab[s.charAt(tail)] > 0)
                        tab[s.charAt(tail)]--;
                    tail++;
                }
                if(res == null || res.length() > i - tail + 1)
                    res = s.substring(tail, i + 1);
            }
        }
        return res == null ? "" : res;
    }
    private boolean containsT(char[] tab, char[] counttab){
        for(int i = 0; i < 256; i++)
            if(tab[i] < counttab[i])
                return false;
        return true;
    }
}
