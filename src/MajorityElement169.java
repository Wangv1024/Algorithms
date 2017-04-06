/**
 * Created by weihengwang on 9/6/16.
 */
public class MajorityElement169 {
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        if(len==1)
            return nums[0];
        int major = nums[0];
        int count = 1;
        for(int i=1;i<len;i++){
            if(count==0){
                major=nums[i];
                count=1;
                continue;
            }
            if(nums[i]!=major)
                --count;
            else
                ++count;
        }
        return major;
    }
    public static void main(String[] args){
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}
