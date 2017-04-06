/**
 * Created by weihengwang on 8/21/16.
 */
public class JumpGameII45 {
    public static int jump2(int[] nums) {
        int[] jumpTab = new int[nums.length];
        if(nums.length <=1)
            return 0;
        jumpTab[nums.length-1] = 0;
        for(int i= nums.length-2; i>=0 ;i--){
            int min = nums.length;
            for(int j=Math.min(nums[i]+i,nums.length-1); j>i; j--) {
                min = Math.min(jumpTab[j]+1, min);
            }
            jumpTab[i]=min;
        }
        return jumpTab[0];
    }

    public static int jump1(int[] nums) {
        int[] jumpTab = new int[nums.length];
        if(nums.length <=1)
            return 0;
        for(int i=0;i<nums.length;i++)
            jumpTab[i]=-1;

        jumpTab[nums.length-1] = 0;
        jumpHelper(jumpTab,nums,0);
        return jumpTab[0];
    }
    private static int jumpHelper(int[] jumpTab,int[] nums,int st){
        if(jumpTab[st]!=-1)
            return jumpTab[st];
        int i = st;
        int min = nums.length;
        int jBound = Math.min(nums.length-1, i+nums[i]);
        for(int j=i+1; j<=jBound; j++) {
            min = Math.min(jumpHelper(jumpTab,nums,j)+1, min);
        }
        jumpTab[i]=min;
        return jumpTab[st];
    }

    public static int jump3(int[] nums) {
        int[] jumpTab = new int[nums.length];
        if(nums.length <=1)
            return 0;
        jumpTab[nums.length-1] = 0;
        for(int i= 0; i<nums.length ;i++){
            int min = nums.length;
            int jBound = Math.min(nums.length-1, i+nums[i]);
            for(int j=i+1; j<=jBound; j++) {
                min = Math.min(jumpTab[j]+1, min);
            }
            jumpTab[i]=min;
        }
        return jumpTab[0];
    }

    public static int jumpxx(int[] nums) {
        if(nums.length <=1)
            return 0;
        int steps = 1;
        int currentMax = nums[0]+0;
        int nextMax = 0;
        for(int i=1;i<nums.length;i++){
            while(i<=currentMax && i<nums.length) {
                nextMax = Math.max(nextMax, nums[i] + i);
                i++;
            }
            if(i<nums.length)
                steps++;
            currentMax = nextMax;
            System.out.println("i:"+i+" curentMax:"+currentMax);
        }
        return steps;
    }

    public static int jump(int[] nums) {
        if(nums.length <=1)
            return 0;
        int steps = 1;
        int currentMax = nums[0]+0;
        int nextMax = currentMax;
        for(int i=1;i<nums.length;i++){
            nextMax = Math.max(nextMax,nums[i]+i);

            if(i>currentMax){
                steps ++;
                currentMax =nextMax;
            }
        }
        return steps++;
    }

    public static int jumpas(int[] A) {
        int steps = 0;
        int lastjump = 0;
        int currentMaxj = 0;
        for(int i=0;i<A.length-1;i++){
            currentMaxj = Math.max(A[i]+i, currentMaxj);
            if(lastjump == i){
                steps++;
                lastjump = currentMaxj;
            }
        }
        return steps;
    }
    public static void main(String[] args){
   //     int[] testArr = {7,3,1,1,6,1,1,1,1,1};
  //      int[] testArr = {1,2,0,1};
        int[] testArr = {1,1,2,1,1};
        System.out.print(jumpas(testArr));
    }
}
