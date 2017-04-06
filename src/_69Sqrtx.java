/**
 * Created by weihengwang on 2/16/17.
 */
public class _69Sqrtx {
    public int mySqrt(int x) {
        int res = Integer.MIN_VALUE;

        int high = x, low = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int tmp = mid * mid;
            if(tmp == x)
                return mid;
            else if(tmp > x)
                high = mid - 1;
            else {
                res = Math.max(res, mid);
                low = mid + 1;
            }
        }
        return res;
    }
}
