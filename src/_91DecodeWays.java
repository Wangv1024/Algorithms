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
}
