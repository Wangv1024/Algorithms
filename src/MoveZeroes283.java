import java.util.Arrays;

/**
 * Created by weihengwang on 9/6/16.
 */
public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
        int nonp = -1;
        if(nums.length<=1)
            return;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                ++nonp;
                nums[nonp] = nums[i];
            }
        }
        nonp++;
        while(nonp<nums.length){
            nums[nonp]=0;
            nonp++;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2};
        moveZeroes(arr);
        System.out.print(Arrays.toString(arr));
    }
}
