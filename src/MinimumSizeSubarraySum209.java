/**
 * Created by weihengwang on 9/4/16.
 */
public class MinimumSizeSubarraySum209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len<1)
            return 0;
        int ed=0;
        int le=Integer.MAX_VALUE;
        int sum =0;
        for(int i=0;i<len;i++){
            sum=sum+nums[i];
            while(sum-nums[ed]>=s){
                sum=sum-nums[ed];
                ++ed;
            }
            if(sum>=s)
                le=Math.min(le,i-ed+1);

        }
        return le==Integer.MAX_VALUE? 0:le;
    }
    public static void main(String[] args){
    //    int[] Arr = {1,1,2,4,9}
        int[] Arr = {};
        System.out.print(minSubArrayLen(100,Arr));
    }
}
