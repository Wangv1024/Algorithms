import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by weihengwang on 1/20/17.
 */
public class _117PopulatingNextRightPointersinEachNodeII {
//    public void connect(TreeLinkNode root) {
//        if(root == null || (root.left == null && root.right == null) )
//            return;
//        TreeLinkNode cur = root, backup = root.left != null? root.left: root.right;
//
//        while(cur != null || backup != null){ // Forget update
//            if(cur == null) {
//                cur = backup;
//                backup = null; // error not update
//            }
//            if(backup == null && (cur.left != null || cur.right != null) ){ // error assumption
//                backup = cur.left != null? cur.left:cur.right;
//            }
//
//            if(cur.left == null && cur.right == null) {
//                cur = cur.next;
//                continue;
//            }
//
//            if(cur.left != null && cur.right != null){
//                cur.left.next = cur.right;
//            }
//
//            TreeLinkNode tmp = cur.next;
//            while(tmp != null && tmp.left == null && tmp.right == null)
//                tmp = tmp.next;
//            if(tmp != null){
//                TreeLinkNode tmplinkedNode = tmp.left != null? tmp.left : tmp.right;
//                TreeLinkNode curchildNode = cur.right != null? cur.right : cur.left;
//                curchildNode.next = tmplinkedNode;
//            }
//            cur = cur.next;
//
//        }
//
//    }

//        public void connect(TreeLinkNode root) {
//            if(root == null || (root.left == null && root.right == null) )
//                return;
//            TreeLinkNode cur = root, backup = root.left != null? root.left: root.right;
//
//            while(cur != null || backup != null){  // Forget update
//                if(cur == null) {
//                    cur = backup;
//                    backup = null;
//                }
//                if(backup == null && (cur.left != null || cur.right != null) ){
//                    backup = cur.left != null? cur.left:cur.right;
//                }
//
//                if(cur.left == null && cur.right == null) {
//                    cur = cur.next;
//                    continue;
//                }
//
//                if(cur.left != null && cur.right != null){
//                    cur.left.next = cur.right;
//                }
//
//                TreeLinkNode tmp = cur.next;
//                while(tmp != null && tmp.left == null && tmp.right == null)
//                    tmp = tmp.next;
//                if(tmp != null){
//                    TreeLinkNode tmplinkedNode = tmp.left != null? tmp.left : tmp.right;
//                    TreeLinkNode curchildNode = cur.right != null? cur.right : cur.left;
//                    curchildNode.next = tmplinkedNode;
//                }
//                cur = cur.next;
//            }
//        }
    public void connect(TreeLinkNode root) {
        if(root == null)
            return ;
        Queue<TreeLinkNode> que = new LinkedList<>();
        que.offer(root);

        while(que.isEmpty() == false){
            TreeLinkNode prev = null;
            int levelsize = que.size();
            for(int i = 0; i < levelsize; i++){
                TreeLinkNode cur = que.poll();
                if(prev != null){
                    prev.next = cur;
                }
                prev = cur;
                if(cur.left != null)
                    que.offer(cur.left);
                if(cur.right != null)
                    que.offer(cur.right);
            }
        }

    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
