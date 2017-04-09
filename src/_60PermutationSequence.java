import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 4/9/17.
 */
public class _60PermutationSequence {
    public String getPermutation(int n, int k) {
        if(n == 1)
            return "1";
        List<Integer> candid = new ArrayList<>();
        for(int i = 1; i <= 9; i++)
            candid.add(i);

        StringBuilder strb = new StringBuilder();
        k--;
        for(int i = n - 1; i >= 0; i--){
            int number = calculate(i);
            int kth = k / number;
            k = k % number;

            strb.append( candid.get(kth) );
            candid.remove(kth);

            // if(number > k){ 
            //     strb.append( candid.get(0) );
            //     candid.remove(0);
            // }
            // else{
            //     int kth = k / number;
            //     k = k % number;
            //     strb.append( candid.get(kth) );
            //     candid.remove(kth);
            // }
        }

        return strb.toString();
    }
    private int calculate(int n){
        int ret = 1;
        while(n > 1){
            ret = ret * n;
            n--;
        }
        return ret;
    }
}
