/**
 * Created by weihengwang on 2/15/17.
 */
public class _42TrappingRainWater {
    public static int trap(int[] height) {
        if(height.length <= 2)
            return 0;
        int water = 0;
        int left = 0, leftlevel = height[0];
        int right = height.length - 1;   // get wrong with 0
        int rightlevel = height[height.length - 1];
        int curlev = Math.min(leftlevel, rightlevel);
        while(left + 1 < right){
            int temp;
            if(leftlevel <= rightlevel){
                left++;
                leftlevel = Math.max(leftlevel, height[left]);
                temp = curlev - height[left];
            }
            else{
                right--;
                rightlevel = Math.max(rightlevel, height[right]);
                temp = curlev - height[right];
            }
            water = water + ( temp > 0 ? temp : 0);
            curlev = Math.min(leftlevel, rightlevel);
        }

        return water;
    }

    public static void main(String[] args){
        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(test));
    }
}
