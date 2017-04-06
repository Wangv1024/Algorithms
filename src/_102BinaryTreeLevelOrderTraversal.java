import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by weihengwang on 2/17/17.
 */
public class _102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(que.isEmpty() == false){
            int curlevel = que.size();
            List<Integer> ls = new LinkedList<>();
            for(int i = 0; i < curlevel; i++){
                TreeNode curnode = que.poll();
                ls.add(curnode.val);
                if(curnode.left != null)
                    que.offer(curnode.left);
                if(curnode.right != null)
                    que.offer(curnode.right);
            }
            res.add(ls);
        }
        return res;
    }
}
