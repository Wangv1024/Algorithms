/**
 * Created by weihengwang on 2/13/17.
 */
public class _110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int[] res = helper(root);
        return res[0] == 1;
    }
    public int[] helper(TreeNode tn){
        int[] re = new int[2];
        if(tn == null){
            re[0] = 1;
            return re;
        }

        int[] left = helper(tn.left);
        int[] right = helper(tn.right);
        if(left[0] != 1 || right[0] != 1)
            return re;

        if(Math.abs(left[1] - right[1]) > 1)
            return re;
        re[0] = 1;
        re[1] = Math.max(left[1], right[1]);
        return re;
    }
}
