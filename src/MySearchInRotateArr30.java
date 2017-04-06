
/**
 * Created by weihengwang on 8/20/16.
 */
public class MySearchInRotateArr30 {
    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
                //      else if(nums[mid] <= nums[left] && nums[mid] <= nums[right]){
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    return binarySearch(nums, mid+1, right, target);
                else
                    right = mid -1;
            }
            //     else{ //if(nums[mid] >= nums[left] && nums[mid] >= nums[right]){
            else if(nums[mid] >= nums[right]){
                if(target >= nums[left] && target < nums[mid])
                    return binarySearch(nums, left, mid-1, target);
            //        right = mid -1;
                else
                    left = mid + 1;
            }

        }
        return -1;
    }

    private static int binarySearch(int[] nums, int left, int right, int target){

        while(left <= right){
            int mid = (right + left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid +1;
            else
                right = mid -1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] testArr = {10,12,14,1,3,4,5,6,8};
        int[] testBinary = {1,3,5,7,9,11,15};
        //      System.out.print(binarySearch(testBinary,0,6,1));
        System.out.print(search(testArr,1));
    }
}

