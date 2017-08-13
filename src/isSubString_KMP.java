/**
 * Created by weihengwang on 6/15/17.
 */
public class isSubString_KMP {
    public static boolean isSubstring(String str1, String str2){
        if(str2.length() <= 0)
            return true;
        int[] prefix = getprefixFunction(str2);

        for(int i = 0, j = 0; i < str1.length(); i++){
            if(j < str2.length() && str1.charAt(i) == str2.charAt(j)){
                j ++;
                if(j == str2.length()){
                    j = prefix[j - 1];
                    return true;
                }
            }
            else{
                if(j > 0){
                    j = prefix[j - 1];
                    i--;
                }
            }
        }
        return false;
    }
    private static int[] getprefixFunction(String s){
        int[] tab = new int[ s.length() ];
        for(int i = 1, j = 0; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(j)){
                j++;
                tab[i] = j;
            }
            else{
                if(j > 0){
                    j = tab[j - 1];
                    i --;
                }
            }
        }
        return tab;
    }

//    public static boolean isSubstring(String str1, String str2){
//        if(str2.length() <= 0)
//            return true;
//        int[] tab = gettab(str2);
//        for(int i = 0, j = 0; i < str1.length(); i++){
//            if(j < str2.length() && str1.charAt(i) == str2.charAt(j)){
//                j ++;
//                if(j == str2.length()){
//                    j = tab[j - 1];
//                    return true;
//                }
//            }
//            else{
//                if(j != 0){
//                    j = tab[j - 1];
//                    i = i - 1;
//                }
//            }
//        }
//        return false;
//    }
//    public static int[] gettab(String str){
//        int[] tab = new int[str.length()];
//        for(int i = 1, j = 0; i < str.length(); i++){
//            if(str.charAt(i) == str.charAt(j)){
//                j++;
//                tab[i] = j;
//            }
//            else{
//                if(j == 0){
//                    tab[i] = 0;
//                }
//                else {
//                    i = i - 1;
//                    j = tab[j - 1];
//                }
//            }
//        }
//        return tab;
//    }

    public static void main(String[] args){
        String s = "aaadbfsdgig";
        String d = "adbe";
        System.out.println(isSubstring(s, d));
    }
}
