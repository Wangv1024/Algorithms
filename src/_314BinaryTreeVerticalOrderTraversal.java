import java.util.List;

/**
 * Created by weihengwang on 3/23/17.
 */
public class _314BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args){
        int[] arr = {1,3,5,6,7,9,10};
        System.out.println(findgreatequal(arr, 0));
    }

    public static int findgreatequal(int[] nums, int target){
        int st = 0, end = nums.length;
        while(st < end){
            int mid = st + (end - st) / 2;
            if(nums[mid] < target)
                st = mid + 1;
            else
                end = mid;
        }
        return end;
    }
}
