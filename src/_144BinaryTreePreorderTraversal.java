import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 6/6/17.
 */
public class _144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Deque<TreeNode> st = new LinkedList<>();

        while (root != null || !st.isEmpty()) {
            if (root == null) {
                root = st.pop();
            }

            res.add(root.val); // it is value not treeNode
            if (root.right != null)
                st.push(root.right);
            root = root.left;
        }
        return res;
    }
}
