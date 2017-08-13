import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 3/2/17.
 */
public class _46Permutations {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        if(nums.length == 0)
//            return res;
//
//        helper(nums, 0, new LinkedList<Integer>(), res);
//        return res;
//    }
//
//    public void helper(int[] nums, int st, List<Integer> tmp, List<List<Integer>> res){
//        if(st >= nums.length) {
//            List<Integer> newlist = new LinkedList<>(tmp);
//            res.add(newlist);
//            return;
//        }
//
//        for(int i = st; i <= nums.length - 1; i++){
//            swap(nums, i, st);
//            tmp.add(nums[st]);
//            helper(nums, st + 1, tmp, res);
//
//            swap(nums, i, st);
//            tmp.remove(tmp.size() - 1);
//        }
//    }
//
//    private void swap(int[] nums, int st, int i){
//        int tmp = nums[st];
//        nums[st] = nums[i];
//        nums[i] = tmp;
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length <= 0)
            return res;
        getpermute(res, nums, 0);
        return res;
    }
    private void getpermute(List<List<Integer>> res, int[] nums, int st){
        if(st >= nums.length){
            List<Integer> tmp = new LinkedList<>();
            for(int num : nums)
                tmp.add(num);
            res.add(tmp);
            return;
        }

        for(int i = st; i < nums.length; i++ ){
            swap(nums, st, i);
            getpermute(res, nums, st + 1);
            swap(nums, st, i);
        }
    }
    private void swap(int[] arr, int st, int end){
        if(st == end)
            return;
        arr[st]  = arr[st] ^ arr[end];
        arr[end] = arr[st] ^ arr[end];
        arr[st]  = arr[st] ^ arr[end];
    }
}
