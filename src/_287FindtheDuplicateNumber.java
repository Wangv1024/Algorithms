/**
 * Created by weihengwang on 2/16/17.
 */
public class _287FindtheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        while(min <= max){
            int mid = min + (max - min) / 2;
            int count = 0, equal = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] < mid)
                    count++;
                if(nums[i] == mid)
                    equal++;
            }
            if(equal > 1)
                return mid;
            if(count > mid - min)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        int top = nums.length - 1;
        int down = 1;
        int equal = 0, less = 0;
        while(down <= top){
            int mid = down + (top - down)/2;
            for(int num : nums){
                if(num == mid)
                    equal++;
                if(num < mid)
                    less++;
            }

            if(equal > 1)
                return mid;
            else if(less > mid - 1){
                top = mid - 1;
            }
            else
                down = mid + 1;

            equal = 0;
            less = 0;
        }
        return -1;
    }

    public int findDuplicate3(int[] nums) {
        if(nums.length <= 2)
            return nums[1];
        int st = 1, end = nums.length - 1;
        while(st <= end){
            int mid = st + ( end - st ) / 2;
            int equal = 0, below = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == mid)
                    equal++;
                else if(nums[i] < mid)
                    below ++;
            }

            if(equal > 1)
                return mid;
            if(below > mid - 1)
                end = mid - 1;
            else
                st = mid + 1;

        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,2,2,7};
        System.out.println(findDuplicate(nums));
    }
}
