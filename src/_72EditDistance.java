/**
 * Created by weihengwang on 2/23/17.
 */
public class _72EditDistance {
    public static int minDistance(String word1, String word2) {
        if(word1.length() <= 0 && word2.length() <= 0)
            return 0;
        if(word1.length() == 0 || word2.length() == 0)
            return word1.length() == 0? word2.length() : word1.length();

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] table = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++)
            table[i][0] = i;
        for(int j = 0; j <= len2; j++)
            table[0][j] = j;

        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                int replace = 1;
                if(word1.charAt(i) == word2.charAt(j))
                    replace = 0;
                table[i + 1][j + 1] = Math.min( table[i + 1][j] + 1 , Math.min(table[i][j] + replace, table[i][j + 1] + 1));
            }
        }

        return table[len1][len2];
    }

    public static void main(String[] args){
        String str1 = "aabbcce";
        String str2 = "abcce";
        System.out.println(minDistance(str1, str2));
    }
}
