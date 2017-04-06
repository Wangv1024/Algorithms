/**
 * Created by weihengwang on 3/7/17.
 */
public class _236LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == p || root == q || root == null)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right != null || left != null && right == null )
            return left == null? right : left;

        if(left != null && right != null)
            return root;

        return null;
    }
}
