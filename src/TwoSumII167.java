import java.util.Arrays;

/**
 * Created by weihengwang on 9/6/16.
 */
public class TwoSumII167 {
    public static int[] twoSum(int[] numbers, int target) {
        int p1=0,p2=numbers.length-1;
        int[] res = new int[2];
        if(numbers.length<2)
            return res;
        while(p1+1<p2){
            if(numbers[p1]+numbers[p2]==target)
                break;
            else if(numbers[p1]+numbers[p2]<target)
                ++p1;
            else
                --p2;
        }
        res[0] = p1+1;
        res[1] = p2+1;
        return res;
    }
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        System.out.print(Arrays.toString(twoSum(nums,18)));
    }
}
