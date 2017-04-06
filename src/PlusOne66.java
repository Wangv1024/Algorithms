import java.util.Arrays;

/**
 * Created by weihengwang on 9/6/16.
 */
public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len<1) {
            int[] res = {1};
            return res;
        }
        digits[digits.length-1]++;
        int carry=0;
        for(int i=digits.length-1;i>=0;--i){
            if(carry>0){
                carry=0;
                digits[i]++;
            }
            if(digits[i]>=10){
                carry=1;
                digits[i]=digits[i]%10;
            }
        }

        int[] res = new int[len+1];
        if(carry==1){
            digits[0] = digits[0]%10;
            res[0] = 1;
            for(int i=0;i<len;i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        else
            return digits;
    }
    public static void main(String[] args){
        int[] arr = {1,2,4};
        System.out.print(Arrays.toString(plusOne(arr)));
    }
}
