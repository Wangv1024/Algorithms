import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 3/2/17.
 */
public class _47PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length <= 0)
            return res;

        Arrays.sort(nums);
        int[] used = new int[nums.length];
        helper(nums, res, new LinkedList<Integer>(), 0, used);
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int st, int[] used){
        if(st >= nums.length){
            List<Integer> ret = new LinkedList<>(tmp);
            res.add(ret);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1 || i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0)
                continue;
            used[i] = 1;
            tmp.add(nums[i]);
            helper(nums, res, tmp, st + 1, used);
            tmp.remove(tmp.size() - 1);
            used[i] = 0;
        }
    }

//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        Arrays.sort(nums);
//        getPermute(res, nums, 0);
//        return res;
//    }
//    private void getPermute(List<List<Integer>> res, int[] nums, int st){
//        if(st >= nums.length){
//            List<Integer> ls = new LinkedList<>();
//            for(int num : nums)
//                ls.add(num);
//            res.add(ls);
//            return;
//        }
//        int[] newarr = new int[nums.length];
//        System.arraycopy(nums, 0, newarr, 0, nums.length);
//
//        for(int i = st; i < newarr.length; i++){
//            if( st != i && newarr[st] == newarr[i] )
//                continue;
//            swap(newarr, st, i);
//            getPermute(res, newarr, st + 1);
//            //		swpa(nums, st, i);
//        }
//
//    }
//    private void swap(int[] nums, int st, int end){
//        if(st == end)
//            return;
//        nums[st] = nums[st] ^ nums[end];
//        nums[end] = nums[st] ^ nums[end];
//        nums[st] = nums[st] ^ nums[end];
//    }
}
