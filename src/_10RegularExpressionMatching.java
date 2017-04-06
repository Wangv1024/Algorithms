/**
 * Created by weihengwang on 3/19/17.
 */
public class _10RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 0; i < plen; i ++){
            if(p.charAt(i) == '*')
                dp[0][i + 1] = dp[0][i - 1] || dp[0][i];
        }
        for(int i = 0; i < slen; i++){ // i for s
            for(int j = 0; j < plen; j++){  // j for p
                if(p.charAt(j) == '.')
                    dp[i + 1][j + 1] = dp[i][j];
                else if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')
                       dp[i + 1][j + 1] = dp[i + 1][j ] || dp[i][ j + 1];
//                    if(s.charAt(i) == p.charAt(j - 1))
//                        dp[i + 1][j + 1] = dp[i + 1][j + 1] || ;
                    dp[i + 1][ j + 1] = dp[i + 1][j + 1] || dp[i + 1][ j - 1];
                }
                else if(p.charAt(j) == s.charAt(i))
                    dp[i + 1][j + 1] = dp[i][j];
            }
        }
        return dp[slen][plen ]; // bugs
    }

    public static void main(String[] args){
        String s = "aaab";
        String b = "ac*b";
        System.out.println(isMatch(s, b));
    }
}
