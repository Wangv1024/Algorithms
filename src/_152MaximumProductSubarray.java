/**
 * Created by weihengwang on 6/14/17.
 */
public class _152MaximumProductSubarray {
    public int maxProduct(int[] A) {
        int res = A[0];
        int max = A[0], min = A[0];
        for(int i = 1; i < A.length; i++){

            if(A[i] < 0 && max != min) {

                max = max ^ min;
                min = max ^ min;
                max = max ^ min;
            }

            max = Math.max(A[i], max * A[i]);
            min = Math.min(A[i], min * A[i]);

            res = Math.max(res, max);
        }
        return res;
    }

}
