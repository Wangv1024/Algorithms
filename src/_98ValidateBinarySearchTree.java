/**
 * Created by weihengwang on 2/16/17.
 */
public class _98ValidateBinarySearchTree {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isValid(root);
    }

    public boolean isValid(TreeNode root){

        if(root.left != null && isValid(root.left) == false)
            return false;

        if(prev != null && prev.val >= root.val)
            return false;

        prev = root;
        if(root.right != null && isValid(root.right) == false)
            return false;

        return true;
    }
}
