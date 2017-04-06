import java.util.HashMap;

/**
 * Created by weihengwang on 9/2/16.
 */
public class LongestConsecutiveSequence128 {
    public static int longestConsecutive(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        int max =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curnum = nums[i];
            if(!hm.containsKey(curnum)){

                int up = (hm.containsKey(curnum+1))? hm.get(curnum+1):0;
                int down = (hm.containsKey(curnum-1))? hm.get(curnum-1):0;

                int sum = up+down+1;
                hm.put(curnum,sum);

                max= Math.max(max,sum);
                if(up>0) hm.put(curnum+up,sum);
                if(down>0) hm.put(curnum-down,sum);
                System.out.println(" i: "+i+" nums[]:"+nums[i]+" sum:"+sum);
            }
        }
        return max;
    }

    public static void main(String[] args){
    //    int[] arr = {100,4,200,1,3,2};
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.print(longestConsecutive(arr));
    }
}
