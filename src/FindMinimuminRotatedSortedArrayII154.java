/**
 * Created by weihengwang on 8/29/16.
 */
public class FindMinimuminRotatedSortedArrayII154 {
    public static int findMin(int[] nums) {
        if(nums.length<1){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (right-left)/2+left;
            if(nums[mid]<nums[right]){
                right = mid;
            }
            else if(nums[mid]>nums[right]){
                left = mid+1;
            }
            else {
                right--;
            }
        }
        return nums[left];
    }
    public static void main(String[] args){
        int[] arr = {4,1,2,4};
        System.out.print(findMin(arr));
    }
}
