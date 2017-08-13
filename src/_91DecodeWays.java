/**
 * Created by weihengwang on 5/9/17.
 */
public class _91DecodeWays {
    public int numDecodings(String s) {
        if(s.length() <= 0)
            return 0;
        int[] tab = new int[s.length() + 1];
        tab[s.length()] = 1;
        if(s.charAt(s.length() - 1) >= '1')
            tab[s.length() - 1] = 1;

        for(int i = s.length() - 2; i >= 0; i--){
            if(s.charAt(i) == '0')
                tab[i] = 0;
            else{
                tab[i] = tab[i + 1];
                if(Integer.parseInt(s.substring(i, i + 2)) <= 26)
                    tab[i] += tab[i + 2];
            }

        }

        return tab[0];
    }
    public int numDecodings2(String s) {
        if(s.length() == 0 || s.startsWith("0"))
            return 0;
        int[] tab = new int[s.length() + 1];
        tab[0] = 1;
        for(int  i = 0; i < s.length(); i ++){
            if( i + 1 <= s.length()){
                String str = s.substring(i, i + 1);
                if( !str.startsWith("0") && Integer.parseInt(str) <= 26 )
                    tab[i + 1] += tab[i];
            }
            if( i + 2 <= s.length()){
                String str = s.substring(i, i + 2);
                if( !str.startsWith("0") && Integer.parseInt(str) <= 26 )
                    tab[i + 2] += tab[i];
            }
        }
        return tab[s.length()];
    }
}
