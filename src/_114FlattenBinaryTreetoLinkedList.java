import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 5/15/17.
 */
public class _114FlattenBinaryTreetoLinkedList {

    TreeNode prev = null;
    public void flatten_bypreorder(TreeNode root){
        preorder(root);
    }
    // Use preorder traverse property:
    private void preorder(TreeNode root){
        if(root == null)
            return;
        // At current node break all the connection with
        // its child node. but reserved its children
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;

        // if current node exist previous node, linked it with current node
        if(prev != null){
            prev.right = root;
        }
        // connection finished, update previous node
        prev = root;

        // go next node by preoder traverse order
        preorder(left);
        preorder(right);
    }

    public void flatten(TreeNode root){
        flattenthis(root);
    }
    private TreeNode flattenthis(TreeNode root){
        TreeNode tail = null;
        while(root != null){
            if(root.left != null){
                tail = flattenthis(root.left);

                tail.right = root.right;  // flatten process
                root.right = root.left;
                root.left = null;

                root = tail.right;
            }
            else {
                tail = root;
                root = root.right;
            }
        }
        return tail;
    }

    public void flatten2(nestNode root){
        flattenthis(root);
    }
    private nestNode flattenthis(nestNode root){
        nestNode tail = null;
        while(root != null){
            if(root.below != null){
                tail = flattenthis(root.below);

                tail.next = root.next;  // flatten process
                root.next = root.below;
                root.below = null;

                root = tail.next;
            }
            else {
                tail = root;
                root = root.next;
            }
        }
        return tail;
    }

    // Time complexity of this approach: 2n,  each node goes through one times inner loop
    //  and one times outer loop,
     public void flatten3(TreeNode root) {
         Deque<TreeNode> st = new LinkedList<>();
         while(root != null){
             if(root.left != null){
                 TreeNode leftTree = root.left;
                 TreeNode rightTree = root.right;
                 TreeNode leftTreeRightMost = leftTree;
                 while(leftTreeRightMost.right != null)
                     leftTreeRightMost = leftTreeRightMost.right;

                 root.left = null;
                 leftTreeRightMost.right = rightTree;
                 root.right = leftTree;

                 root = root.right;
             }
             else
                 root = root.right;
         }
     }
}

class nestNode {
    nestNode next;
    nestNode below;
    int val;
    public nestNode(int va){
        val = va;
    }
}