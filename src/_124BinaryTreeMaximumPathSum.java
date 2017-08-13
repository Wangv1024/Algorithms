/**
 * Created by weihengwang on 2/27/17.
 */
public class _124BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return Integer.MIN_VALUE;
        int[] res = helper(root);
//        helper(root, res);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root){
        int[] ret = new int[2];
        ret[0] = root.val;
        ret[1] = root.val;
        if(root.left == null && root.right == null)
            return ret;

        if(root.left != null && root.right != null) {

            int[] left = helper(root.left);   // ret[0] is cross node sum  ret[1] is one side sum
            int[] right = helper(root.right);

            ret[1] = Math.max( Math.max(left[1], right[1]) + root.val, root.val);

            ret[0] = Math.max(right[0], Math.max(left[0], right[1] + left[1] + root.val));
            ret[0] = Math.max(ret[1], ret[0]);
            return ret;
        }
        else{
            TreeNode notnull = root.left != null ? root.left : root.right;
            int[] tmp = helper(notnull);

            ret[1] = Math.max(root.val, root.val + tmp[1]);
            ret[0] = Math.max(tmp[0], ret[1]);
            return ret;
        }
    }


    int max;   // better approach
    public int maxPathSum1(TreeNode root) {
        if(root == null)
            return Integer.MIN_VALUE;
        if(root.left == null && root.right == null)
            return root.val;
        getMaxPath(root);
        return max;
    }
    private int getMaxPath(TreeNode root){
        int leftM = 0, rightM = 0;
        if(root.left != null)
            leftM = Math.max( getMaxPath(root.left), 0);
        if(root.right != null)
            rightM = Math.max( getMaxPath(root.right), 0);

        max = Math.max(max, leftM + rightM + root.val);
        return Math.max(leftM, rightM) + root.val;
    }
}


