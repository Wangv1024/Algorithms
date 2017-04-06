/**
 * Created by weihengwang on 3/23/17.
 */
public class _29DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        if(divisor == 1)
            return dividend;
        if(divisor == -1)
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : 0 - dividend;

        int sign = (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) ? -1 : 1;
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
//        if(divid < divis)
//            return 0;
        int times = 1;
        while(divid - (divis << 1) >= 0){
            divis = divis << 1;
            times = times << 1;
        }
        int total = 0;
        while( divis >= Math.abs( (long) divisor)){
            while(divid - divis >= 0) {
                total += times;
                divid -= divis;
            }
            divis = divis >>> 1;
            times = times >>> 1;
        }

        return sign > 0 ? total : 0 - total;
    }
    public static void main(String[] args){
        System.out.println(divide(-2147363648, -2147363648));
    }
}
