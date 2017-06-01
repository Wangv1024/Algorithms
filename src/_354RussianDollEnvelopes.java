import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by weihengwang on 5/21/17.
 */
public class _354RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length <= 1)
            return envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[0] != a2[0])
                    return a1[0] - a2[0];
                return a2[1] - a1[1];
            }
        });

        int[] dp = new int[envelopes.length];
        int lenSofar = 0;
        for(int[] oneEnvelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, lenSofar, oneEnvelope[1]);
            if(index < 0)
                index = - (index + 1);
            dp[index] = oneEnvelope[1];
            if(index == lenSofar)
                lenSofar++;
        }
        return lenSofar;
    }

    // public int maxEnvelopes(int[][] envelopes) {  // general approach
    //     if(envelopes.length <= 0)
    //         return 0;
    //     Arrays.sort(envelopes, new Comparator<int[]>(){
    //         @Override
    //         public int compare(int[] a1, int[] a2){
    //             if(a1[0] != a2[0])
    //                 return a1[0] - a2[0];

    //             return a1[1] - a2[1];
    //         }
    //     });
    //     int[] tab = new int[envelopes.length];
    //     for(int i = 0; i < tab.length; i++)
    //         tab[i] = 1;
    //     int globmax = 1;
    //     for(int cur = 1; cur < envelopes.length; cur ++)
    //         for(int sub = 0; sub < cur; sub ++){
    //             if(envelopes[cur][0] > envelopes[sub][0] && envelopes[cur][1] > envelopes[sub][1]){
    //                 tab[cur] = Math.max(tab[sub] + 1, tab[cur]);
    //                 globmax = Math.max(globmax, tab[cur]);
    //             }
    //         }
    //     return globmax;
    // }
}
