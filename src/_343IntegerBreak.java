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
}
