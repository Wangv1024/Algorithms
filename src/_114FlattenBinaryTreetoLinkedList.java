import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 5/15/17.
 */
public class _114FlattenBinaryTreetoLinkedList {

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