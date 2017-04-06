/**
 * Created by weihengwang on 8/21/16.
 */
public class TrappingRainWater42 {
    public static int trap(int[] height) {
        if(height.length==0)
            return 0;
        int left = 0;
        int leftBar = height[left];
        int right = height.length-1;
        int rightBar = height[right];
        int volume = 0;
        while(left < right) {
            if(leftBar<=height[left])
                leftBar = height[left];
            else
                volume = volume + leftBar - height[left];

            if(rightBar <= height[right])
                rightBar = height[right];
            else
                volume = volume + rightBar - height[right];

            if(leftBar<=rightBar){
                left++;
            }
            else {
                right--;
            }
        }
        return volume;
    }

    public static void main(String[] args){
    //    int[] testArr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] testArr = {0,0,0,4,1,3,0,2};
        System.out.print(trap(testArr));
    }
}
