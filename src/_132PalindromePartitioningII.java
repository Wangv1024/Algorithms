/**
 * Created by weihengwang on 3/2/17.
 */
public class _132PalindromePartitioningII {
//    public static int minCut(String s) {
//        if(s.length() <= 1)
//            return 0;
//        int[] dp = new int[s.length() + 1];
//        for(int i = 0; i < s.length(); i++)
//            dp[i] = -1;
//        dp[s.length()] = 0;
//
//        return helper(s, dp, 0);
//    }
//
//    public static int helper(String s, int[] dp, int st){
//        if(dp[st] != -1)
//            return dp[st];
//        int cut = Integer.MAX_VALUE;
//        for(int i = st; i < s.length(); i++){
//
//            if(ispalidrome(s.substring(st, i + 1))){
//                int tmpcut = helper(s, dp, i + 1);
//                if(i < s.length() - 1)
//                    tmpcut++;
//                cut = Math.min(cut, tmpcut);
//            }
//        }
//        dp[st] = cut;
//        return dp[st];
//    }
//
//    public static boolean ispalidrome(String s){
//        int left = 0, right = s.length() - 1;
//        while(left < right)
//            if(s.charAt(left++) != s.charAt(right--))
//                return false;
//        return true;
//    }

    public static int minCut(String s) {
        int[] tab = new int[s.length() + 1];
        if(s.length() <= 1)
            return 0;

        for(int i = 0; i < tab.length; i++){
            tab[i] = i - 1;
        }

        for(int i = 0; i < s.length(); i++){  // tab[i] means min cut for s[0, i - 1]
            for(int j = 0; i + j < s.length() && i - j >= 0; j++){ // j start from 0 rather than 1
                if(s.charAt(j + i) == s.charAt(i - j)){
                    tab[i + j + 1] = Math.min( tab[i + j + 1], tab[i - j] + 1);
                }
                else
                    break;
            }

            for(int j = 1; j + i < s.length() && i - j + 1 >= 0; j ++){
                if(s.charAt(i + j) == s.charAt(i - j + 1))
                    tab[i + j + 1] = Math.min(  tab[i + j + 1], tab[i - j + 1] + 1);
                else
                    break;
            }
        }

        return tab[s.length()];
    }


    public static void main(String[] args){
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
     //   String input = "aaae";
        System.out.println(minCut(input));
    }
}


