import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weihengwang on 3/19/17.
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length <= 3)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i + 1; j < nums.length - 2; j++){    // j < nums.length ;
                if(j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1, l = nums.length - 1;
                while(k < l){
                    if(k > j + 1 && nums[k] == nums[k - 1]) {
                        k++; continue;
                    }
                    if(l < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        List<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]); ls.add(nums[j]); ls.add(nums[k]); ls.add(nums[l]);
                        res.add(ls);
                        k++;
                    }
                    else if(sum > target)
                        l--;
                    else
                        k++;
                }
            }
        }
        return res;
    }
}
