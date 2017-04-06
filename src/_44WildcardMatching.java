/**
 * Created by weihengwang on 3/31/17.
 */
public class _44WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] tab = new boolean[s.length() + 1][p.length() + 1]; // tab[i][j] indicates matching result of index 0 - i - 1 and 0 - j - 1
        tab[0][0] = true;
        int slen = s.length(), plen = p.length();
        for(int i = 0; i < plen; i++){
            if(p.charAt(i) == '*')
                tab[0][i + 1] = tab[0][i + 1] || tab[0][i - 1];
        }

        for(int i = 0; i < slen; i++){
            for(int j = 0; j < plen; j++){
                if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){
                    tab[i + 1][j + 1] = tab[i + 1][j + 1] || tab[i][j];
                }
                else if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)){
                        tab[i + 1][j + 1] = tab[i + 1][j + 1] || tab[i + 1][j] || tab[i][j + 1];
                    }
                    else
                        tab[i + 1][j + 1] = tab[i + 1][j + 1] || tab[i + 1][j - 1];
                }
            }
        }

        return tab[slen][plen];
    }
}
