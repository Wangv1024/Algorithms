import java.util.HashMap;

/**
 * Created by weihengwang on 2/18/17.
 */
public class _105ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            hm.put(inorder[i], i);

        return helper(preorder, 0, preorder.length - 1, hm, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preSt, int preEnd, HashMap<Integer,Integer> hm, int inst, int inend){
        if(preSt > preEnd)
            return null;
        TreeNode curroot = new TreeNode(preorder[preSt]);
        int rootindx = hm.get(preorder[preSt]);
        int leftItems = rootindx - inst;

        TreeNode leftTree = helper(preorder, preSt + 1, preSt + leftItems, hm, inst, rootindx - 1);
        TreeNode rightTree = helper(preorder, preSt + leftItems + 1, preEnd, hm, rootindx + 1, inend);

        curroot.left = leftTree;
        curroot.right = rightTree;

        return curroot;
    }
}
