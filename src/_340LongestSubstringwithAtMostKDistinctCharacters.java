/**
 * Created by weihengwang on 8/6/17.
 */
public class _340LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0){
            return 0;
        }

        int[] charTab = new int[256];
        int currentK = 0;
        int maxlen = 0;
        int stpt = 0;
        for(int i = 0; i < s.length(); ++ i){
            char ch = s.charAt(i);
            if(charTab[ch] == 0){  // Bugs:  if(charTab[ch] != 0){
                ++ currentK;
            }
            charTab[ch] ++;

            while(currentK > k){
                char toRemove = s.charAt(stpt ++);
                charTab[toRemove] --;
                if(charTab[toRemove] == 0)
                    -- currentK;
            }

            maxlen = Math.max(maxlen, i - stpt + 1);
        }
        return maxlen;
    }
}
