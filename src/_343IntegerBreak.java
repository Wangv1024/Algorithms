/**
 * Created by weihengwang on 4/23/17.
 */
public class _343IntegerBreak {
    public int integerBreak(int n) {

        return breakhelper(n, new int[n + 1]);
    }
    private int breakhelper(int n, int[] tab){
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        if(tab[n] != 0)
            return tab[n];

        for(int nn = 3; nn <= n; nn++) {
            int max = 0;
            for (int br = 1; br <= nn / 2 + 1; br++) {
                max = Math.max( max, Math.max(br, tab[br]) * Math.max(nn - br, tab[nn - br]));
            }
            tab[nn] = max;
        }

        return tab[n];
    }

    public int integerBreak2(int n){
        int[] tab = new int[n + 1]; // tab[i] means the maximum production value
        // can be achieved by breaking value i as at least
        // two parts.
        for(int subn = 2; subn <= n; ++ subn){

            for(int breakPart = 1; breakPart <= subn / 2; ++ breakPart){
                // choose max value between tab[breakPart] and breakPart means we either further break down current integer
                //  or we use current integer breakPart as part of element.
                // We choose max value between these two form a production and choose biggest as result of current element
                //  stores in tab[ subn ]
                int tmp = Math.max(tab[breakPart], breakPart) * Math.max(tab[subn - breakPart], subn - breakPart);
                tab[subn] = Math.max(tab[subn], tmp);
            }
        }
        return tab[n];
    }
}
