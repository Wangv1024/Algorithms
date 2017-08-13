import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 7/29/17.
 */
public class _315CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        Arrays.fill(count, 0);
        int[] index = new int[nums.length];
        for(int i = 0; i < nums.length; ++ i){
            index[i] = i;
        }
        mergeSort(nums, index, count, 0, nums.length - 1);

        return new ArrayList<Integer>( Arrays.asList(count) );
    }
    private void mergeSort(int[] nums, int[] index, Integer[] count, int st, int end){
        if(st >= end)
            return;
        int mid = st + (end - st) / 2;
        mergeSort(nums, index, count, st, mid);
        mergeSort(nums, index, count, mid + 1, end);

        merge(nums, index, count, st, end);
    }
    private void merge(int[] nums, int[] index, Integer[] count, int st, int end){
        int mid = st + ( end - st ) / 2;
        int[] newindex = new int[end - st + 1];
        int lindex = st, rindex = mid + 1, sortindex = 0;
        int rightcount = 0;

        while(lindex <= mid && rindex <= end){
            if( nums[ index[lindex] ] > nums[ index[rindex] ] ){
                rightcount ++;
                newindex[sortindex ++] = index[rindex ++];
            }
            else{
                count[ index[lindex] ] += rightcount;
                newindex[sortindex ++] = index[lindex ++];
            }
        }

        while(lindex <= mid){
            count[ index[lindex] ] += rightcount;
            newindex[ sortindex ++ ] = index[ lindex ++ ];
        }
        while(rindex <= end){
            newindex[ sortindex ++ ] = index[ rindex ++ ];
        }

        for(int i = st; i <= end; ++ i)
            index[ i ] = newindex[i - st];
    }




    public List<Integer> countSmaller2(int[] nums) {
        if(nums.length <= 1){
            List<Integer> res = new LinkedList<>();
            if(nums.length == 1)
                res.add(0);
            return res;
        }
        TreeNode root = null;

        Integer[] count = new Integer[ nums.length ];
        Arrays.fill(count, 0);

        for(int i = nums.length - 1; i >= 0; -- i){
            root = insert(root, count, i, nums);
        }

        return Arrays.asList(count);
    }
    private TreeNode insert(TreeNode root, Integer[] count, int i, int[] nums){
        if(root == null){
            root = new TreeNode(nums[i]);
        }
        else if(root.val < nums[i]){
            count[i] += (root.below + root.dup);
            root.right = insert(root.right, count, i, nums);
        }
        else if(root.val > nums[i]){
            root.below ++;
            root.left = insert(root.left, count, i, nums);
        }
        else{
            root.dup ++;
            count[i] += root.below;
        }
        return root;
    }

    class TreeNode {
        int val, dup = 1, below = 0;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
