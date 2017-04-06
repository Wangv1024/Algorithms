import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by weihengwang on 2/17/17.
 */
public class _103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Deque<TreeNode> st1 = new LinkedList<>();
        Deque<TreeNode> st2 = new LinkedList<>();
        st1.push(root);
        boolean reverse = true;
        while(st1.isEmpty() == false){
            int size = st1.size();
            List<Integer> ls = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curnode = st1.pop();
                ls.add(curnode.val);

                if(reverse == false){
                    if(curnode.right != null){
                        st2.push(curnode.right);
                    }
                    if(curnode.left != null){
                        st2.push(curnode.left);
                    }
                }
                else {
                    if (curnode.left != null) {
                        st2.push(curnode.left);
                    }
                    if (curnode.right != null) {
                        st2.push(curnode.right);
                    }
                }
            }
            reverse = !reverse;
            res.add(ls);
            st1 = st2;
            st2 = new LinkedList<>();
        }
        return res;
    }
}
