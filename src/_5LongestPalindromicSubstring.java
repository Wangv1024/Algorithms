/**
 * Created by weihengwang on 4/13/17.
 */
public class _5LongestPalindromicSubstring {
    //////
    //  Manacher’s Algorithm
    //////
    public String longestPalindrome(String s) {
        char[] arr = new char[2 * s.length() + 1];
        int[] tab = new int[ arr.length ];
        for(int i = 0; i < arr.length; i++)
            arr[i] = i % 2 == 0 ? '$' : s.charAt(i / 2);

        int i = 1;
        int start = 1, end = 1;
        for( i = 1; i < arr.length; ){

            tab[i] = 1;
            while(end + 1 < arr.length && start - 1 >= 0 && arr[start - 1] == arr[end + 1]){
                start --;
                end ++;
            }
            tab[i] = end - start + 1;
            if(end == arr.length - 1)
                break;

            int nextCentral = ( end == i ? end + 1 : end );
            for(int j = i + 1; j <= end; j ++ ){
                int diff = end - j;
                tab[j] = Math.min(diff, tab[i - (j - i)] / 2 ) * 2 + 1;
                if(tab[i - (j - i)] / 2 == diff){
                    nextCentral = j;
                    break;
                }
            }

            start = nextCentral - tab[nextCentral] / 2;
            end = nextCentral + tab[nextCentral] / 2;
            i = nextCentral;
        }
//      System.out.println(Arrays.toString(tab));

        int index = 1, max = 1;
        for(int j = 1; j < arr.length; j++)
            if(tab[j] > max){
                max = tab[j];
                index = j;
            }
        int st = ( index - max / 2 ) / 2;  // bugs  not: int st = index - max / 2;
        int en = ( index + max / 2 ) / 2;  // This is the index in arr tab not original string
        return s.substring(st, en);
    }

    public String longestPalindrome2(String s) {
        if(s.length() <= 1)
            return s;

        char[] newstr = new char[s.length() * 2 + 1];
        int[] tab = new int[s.length() * 2 + 1];
        for(int i = 0, pt = 0; i < newstr.length; i++)
            newstr[i] = ( i % 2 == 0 ? '$' : s.charAt(pt ++) );
        //  copy string into new char array, solving even palidrome situation

        int st = 1, end = 1; // index of expanding boundary
        for(int centr = 1; centr < newstr.length; ) {  // iterate from each index to find next central
            while(st >= 0 && end < newstr.length && newstr[st] == newstr[end]){
                st --; end ++;
            }
            st ++; end --;
            tab[centr] = end - centr;   //  tab[i] stores the length of palidrome from central(exclusive) to end;
            if(end == newstr.length - 1) // early break;
                break;

            int nextCentr = end == centr ? end + 1 : end;
            for(int j = centr + 1; j <= end; j ++) { // iterate from centr + 1 to end to find potential central
                int mirror = tab[centr - (j - centr)];
                int mirrorToLeftBoundary = centr - (j - centr) - st;

                tab[j] = Math.min(mirror, mirrorToLeftBoundary);
                if(mirror == mirrorToLeftBoundary){
                    nextCentr = j; // we find a potential index which can be expend to have longer length. so break;
                    break;
                }
            }

            centr = nextCentr;
            st = centr - tab[centr];
            end = centr + tab[centr];
        }

        int maxhalfLen = 0;
        int index = 1;
        for(int i = 1; i < tab.length; i++)
            if(tab[i] > maxhalfLen){
                maxhalfLen = tab[i];
                index = i;
            }
        return s.substring( (index - tab[index]) / 2, (index + tab[index]) / 2 );
    }
}
