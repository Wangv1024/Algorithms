import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihengwang on 2/28/17.
 */
public class _113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        List<Integer> record = new ArrayList<>();
        helper(root, record, res, sum);
        return res;
    }

    public void helper(TreeNode root, List<Integer> record, List<List<Integer>> res, int sum){
//        if(sum < 0)  // It contains negative number.
//            return;
        if(root.val == sum && root.left == null && root.right == null){
            List<Integer> newlist = new ArrayList<>(record);  // create new instance when adding it.
            newlist.add(root.val);   // Bugs
            res.add(newlist);
            return;
        }

        List<Integer> newlist = new ArrayList<>(record);// 以为在这里新建了obj就没问题, 结果调用 helper (root.left)
        newlist.add(root.val);   // 的时候, newlist 同时被 helper(root.right) 加入。

        if(root.left != null) {
            helper(root.left, newlist, res, sum - root.val);
        }
        if(root.right != null){
            helper(root.right, newlist, res, sum - root.val);
        }
    }
}
