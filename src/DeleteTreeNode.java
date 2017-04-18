import java.util.*;

/**
 * Created by weihengwang on 4/12/17.
 */
public class DeleteTreeNode {
    int glob = 0;
//    public List<TreeNode> afterDelete(TreeNode root){
//        Set<TreeNode> se = new HashSet<>();
//        if(root == null)
//            return new ArrayList<>();
//        if(shouldDelete(root)) {
//            if(root.left != null)
//                se.add(root.left);
//            if(root.right != null)
//                se.add(root.right);
//        }
//        else
//            se.add(root);
//
//        Queue<TreeNode> que = new LinkedList<>();
//        que.offer(root);
//        while(que.isEmpty() == false){
//            TreeNode curnode = que.poll();
//            if(curnode.left != null)
//                que.offer(curnode.left);
//            if(curnode.right != null)
//                que.offer(curnode.right);
//
//            if(curnode.left != null && shouldDelete(curnode.left)){
//                se.remove(curnode.left);
//                se.add(curnode.left.left);
//                se.add(curnode.left.right);
//            }
//            if(curnode.right != null && shouldDelete(curnode.right)){
//                se.remove(curnode.right);
//                se.add(curnode.right.left);
//                se.add(curnode.right.right);
//            }
//        }
//        return new ArrayList<>(se);
//    }

    public static List<TreeNode> afterDelete(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        Set<TreeNode> se = new HashSet<>();
        if(shouldDelete(root) == false) // root node has to be
            se.add(root);

        deleteHelper(root, se);
        return new ArrayList<>(se);
    }

    public static void deleteHelper(TreeNode tn, Set<TreeNode> se){

        if(tn == null)
            return ;
        if(shouldDelete(tn) == true) {
            se.remove(tn);
            if (tn.left != null)
                se.add(tn.left);
            if (tn.right != null)
                se.add(tn.right);
        }

        deleteHelper(tn.left, se);
        deleteHelper(tn.right, se);

        if(shouldDelete(tn.left) == true)
            tn.left = null;
        if(shouldDelete(tn.right) == true)
            tn.right = null;
        if(shouldDelete(tn) == true) {
            tn.left = null;
            tn.right = null;
        }
        return ;
    }

    public static boolean shouldDelete(TreeNode tn){
        if(tn == null)
            return false;

        if(tn.val == 1 || tn.val == 3 || tn.val == 6)
            return true;
        return false;

    }
    public static TreeNode buildTree(int[] arr, int[] indx){
        if(arr[indx[0]] == -1) {
            indx[0] ++;
            return null;
        }
        TreeNode node = new TreeNode(arr[indx[0]]);
        indx[0] ++;
        node.left = buildTree(arr, indx);
        node.right = buildTree(arr, indx);
        return node;
    }

    public static void main(String[] args){
        int[] tree = new int[]{1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        TreeNode root = buildTree(tree, new int[]{0});


        for(TreeNode node : afterDelete(root))
            System.out.print(node.val + " ");

    }

}
//               1
//            /     \
//           2        3
//         /   \    /    \
//        4    5   6      7

