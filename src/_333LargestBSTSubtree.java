import java.util.List;

/**
 * Created by weihengwang on 4/19/17.
 */
public class _333LargestBSTSubtree {
//    int max = 1;
//    public int largestBSTSubtree(TreeNode root) {   // Wrong approach
//        if(root == null)
//            return 0;
//        helper(root);
//        return max;
//    }
//    private Wraper helper(TreeNode root){
//        Wraper res = new Wraper(root.val, root.val, 1);
//        if(root.left != null){
//            Wraper left = helper(root.left);
//            if(left == null || left.max >= root.val)  // when you see one side of tree is invalid
//                return null;                       //  directly return without updating other tree, you miss
                                     //  possible largest tree on another branch
//
//            res.min = left.min;
//            res.size += left.size;
//        }
//
//        if(root.right != null){
//            Wraper right = helper(root.right);
//            if(right == null || right.min <= root.val)
//                return null;
//
//            res.max = right.max;
//            res.size += right.size;
//        }
//        max = Math.max(max, res.size);
//        return res;
//    }

     public int largestBSTSubtree(TreeNode root) {   // worst cases n ^ 2
         if(root == null)
             return 0;

         if(isValid(root, null, null))
             return countNode(root);

         return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
     }
     private boolean isValid(TreeNode tn, Integer min, Integer max ){
         if(tn == null)
             return true;
         if(max != null && tn.val >= max) return false;
         if(min != null && tn.val <= min) return false;

         return isValid(tn.left, min, tn.val) && isValid(tn.right, tn.val, max );
     }
     private int countNode(TreeNode root){
         if(root == null)
             return 0;
         return countNode(root.left) + countNode(root.right) + 1;
     }

    int maxever = 1;
    public int largestBSTSubtree2(TreeNode root) {  // O(n) approach
        if(root == null)
            return 0;
        getLargetBST(root);
        return maxever;
    }
    private int[] getLargetBST(TreeNode root){
        if(root == null)
            return new int[]{0, 0, 0};// size, min element, max element

        int[] leftTree = getLargetBST(root.left);
        int[] rightTree = getLargetBST(root.right);

        // consider left right tree can be invalid BST and can be empty tree
        if(leftTree == null || rightTree == null ||
                leftTree[0] != 0 && leftTree[2] >= root.val ||
                rightTree[0] != 0 && root.val >= rightTree[1] ){
            return null;
        }

        ///  both tree should be valid, but still can be empty,  empty tree has size of 0.
        maxever = Math.max(maxever, leftTree[0] + rightTree[0] + 1);
        int[] ret = new int[]{1, root.val, root.val};
        ret[0] = leftTree[0] + 1 + rightTree[0];
        if(leftTree[0] != 0)
            ret[1] = Math.min(leftTree[1], ret[1]);
        if(rightTree[0] != 0)
            ret[2] = Math.max(rightTree[2], ret[2]);

        return ret;
    }

    
}

