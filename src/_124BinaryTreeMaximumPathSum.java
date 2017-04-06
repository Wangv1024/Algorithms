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


//    public int helper(TreeNode root, int[] res){
//        if(root == null)
//            return 0;
//
//        int left = helper(root.left, res);
//        int right = helper(root.right, res);
//
//        int onesidemax = Math.max( Math.max(left, right), 0) + root.val;
//        int crossmax = Math.max(left + right + root.val, root.val);
//        res[0] = Math.max( Math.max(res[0], crossmax), onesidemax);
//
//        return onesidemax;
//    }

}


