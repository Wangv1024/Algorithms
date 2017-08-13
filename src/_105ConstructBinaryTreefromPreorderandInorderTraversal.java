import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

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
        // Iterative
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(inorder.length == 0)
            return null;
        int prept = 0, inpt = 0;
        Deque<TreeNode> st = new LinkedList<>();
        st.push(new TreeNode( preorder[prept ++]) );
        TreeNode root = st.peek();

        while(prept < preorder.length){ // st stores all the established treeNode
            while(st.peek().val != inorder[inpt]){
                TreeNode newnode = new TreeNode(preorder[prept ++]);
                st.peek().left = newnode;
                st.push(newnode);
            }

            TreeNode inorderVisit = null;
            while( !st.isEmpty() && st.peek().val == inorder[inpt]){
                inpt ++;
                inorderVisit = st.pop();
            }

            if(prept >= preorder.length)
                break;
            TreeNode newNode = new TreeNode( preorder[prept ++] );
            inorderVisit.right = newNode;
            st.push(newNode);
        }
        return root;
    }
}
