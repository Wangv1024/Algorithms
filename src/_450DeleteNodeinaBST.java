/**
 * Created by weihengwang on 5/18/17.
 */
public class _450DeleteNodeinaBST {
    public TreeNode deleteNode2(TreeNode root, int key) {
        if(root == null)
            return null;

        TreeNode curN = root;
        TreeNode prev = null;
        while(curN != null && curN.val != key){
            prev = curN;
            if(curN.val < key)
                curN = curN.right;
            else
                curN = curN.left;
        }

        if(prev == null)
            return deleteHelper(curN);
        if(curN != null) {
            if(prev.left == curN)
                prev.left = deleteHelper(curN);
            else
                prev.right = deleteHelper(curN);
        }

        return root;
    }
    private TreeNode deleteHelper(TreeNode curN){
        if(curN.left == null)
            return curN.right;
        if(curN.right == null)
            return curN.left;

        TreeNode succ = curN.right;
        TreeNode prev = curN;
        while(succ.left != null){
            prev = succ;
            succ = succ.left;
        }

        succ.left = curN.left;
        if(curN.right != succ){
            prev.left = succ.right;
            succ.right = curN.right;
        }
        return succ;
    }

     public TreeNode deleteNode(TreeNode root, int key) {
         if(root == null)
             return null;
         if(key < root.val )
             root.left = deleteNode(root.left, key);
         else if(root.val < key )
             root.right = deleteNode(root.right, key);
         else{
             if(root.left == null)
                 return root.right;
             else if(root.right == null)
                 return root.left;

             TreeNode rightmin = findmin(root.right);
             root.val = rightmin.val;
             root.right = deleteNode(root.right, rightmin.val);
         }

         return root;
     }
     private TreeNode findmin(TreeNode root){
         if(root.left == null)
             return root;
         return findmin(root.left);
     }
}
