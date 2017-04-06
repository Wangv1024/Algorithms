/**
 * Created by weihengwang on 8/21/16.
 */
public class FirstMissingPositive41 {
    public static int firstMissingPositive(int[] nums) {
        int i =0;
        while(i<nums.length){
            if(nums[i]==i+1) i++;
            else if(nums[i]>nums.length || nums[i]<=0) i++;
            else if(nums[nums[i]-1]==nums[i]) i++;
            else
                swap(nums,i,nums[i]-1);
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[] args){
    //    int[] testArr = {3,6,4,8,7,-1,2,5};
        int[] testArr = {1,1};
        System.out.print(firstMissingPositive(testArr));
    }
}
