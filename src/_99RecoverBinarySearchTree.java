import java.util.*;

/**
 * Created by weihengwang on 5/10/17.
 */
public class _99RecoverBinarySearchTree {
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        TreeNode curNode = root;
        while(curNode != null){
            if(curNode.left == null){
                if(prev != null && prev.val >= curNode.val){
                    res.add(prev);
                    res.add(curNode);
                }
                prev = curNode;

                curNode = curNode.right;
            }
            else{
                TreeNode leftn = curNode.left;
                while(leftn.right != null && leftn.right != curNode){
                    leftn = leftn.right;
                }
                if(leftn.right == null){
                    leftn.right = curNode;
                    curNode = curNode.left;
                }
                else{
                    leftn.right = null; // cut this connection
                    // visiting code part
                    if(prev != null && prev.val >= curNode.val){
                        res.add(prev);
                        res.add(curNode);
                    }
                    prev = curNode;
                    curNode = curNode.right; // move to right branch continue visiting
                }
            }
        }
        int tmp = res.get(0).val;
        res.get(0).val = res.get(res.size() - 1).val;
        res.get(res.size() - 1).val = tmp;
    }
}
