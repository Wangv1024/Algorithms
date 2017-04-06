/**
 * Created by weihengwang on 9/5/16.
 */
public class FindtheDuplicateNumber287 {
    public static int findDuplicate(int[] nums) {
        int top = nums.length-1;
        int bottom = 1;
        int count =0;
        int countequal =0;
        while(bottom<top){
            int mid = bottom+((top-bottom)>>1);
            int numbelowmid = mid - 1;
            for(int i =0;i<nums.length;i++){
                if(nums[i]==mid)
                    countequal++;
                if(nums[i]<mid)
                    count++;
            }
            if(countequal>=2)
                return mid;

            if(count>numbelowmid)
                top = mid-1;
            else
                bottom = mid+1;
            count=0;
            countequal=0;
        }
        return bottom;
    }
    public static void main(String[] args){
 //       int[] arr = {1,3,6,4,5,3,2};
        int[] arr = {1,4,4,2,4};
        System.out.println(findDuplicate(arr));
    }
}
