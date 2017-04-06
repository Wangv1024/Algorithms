import java.util.Arrays;

/**
 * Created by weihengwang on 2/13/17.
 */
public class _75SortColors {
    public static void sortColors(int[] nums) {
        if(nums.length <= 1 )
            return ;
        int zero = -1, two = nums.length, one = 0;
        while(one < two) {
            while (one < two && nums[one] == 2) {
                swap(nums, one, --two);
            }
            while (one > zero && nums[one] == 0) {
                swap(nums, one, ++zero);
            }
            one++;
        }

    }
    private static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public static void main(String[] args){
        int[] nums = {2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
