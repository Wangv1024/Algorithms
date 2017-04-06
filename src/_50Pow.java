/**
 * Created by weihengwang on 2/15/17.
 */
public class _50Pow {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        if(x == 0)
            return 0;
        double base = x;
        long ln = n;
        int sign = 1;
        if(n < 0) {
            base = 1 / x;
            ln = -ln;
        }

        if(x < 0 && ln % 2 ==1)
            sign = -1;

        if(x < 0)
            base = - base;

        if(ln % 2 == 1)  // myPow(base, (int) (ln / 2) ) * myPow(base, (int) (ln / 2)) will TLE
            return myPow(base, (int) (ln / 2) ) * myPow(base, (int) (ln / 2)) * base * sign;
        else
            return myPow(base, (int) (ln / 2) ) * myPow(base, (int) (ln / 2)) * sign;

    }
}
