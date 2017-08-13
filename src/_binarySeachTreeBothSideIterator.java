import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 6/17/17.
 */
public class _binarySeachTreeBothSideIterator {
    public static TreeNode[] findPair(TreeNode root, int target){
        TreeNode[] res = new TreeNode[2];
        if(root == null || root.left == null && root.right == null)
            return null;

        TreeIterator iterleft = new TreeIterator(root, true);
        TreeIterator iterright = new TreeIterator(root, false);

        TreeNode left = iterleft.hasNext()? iterleft.next() : null;
        TreeNode right = iterright.hasNext()? iterright.next() : null;
        while(left != null && right != null && left != right){
            if(left.val + right.val == target){
                res[0] = left;
                res[1] = right;
                return res;
            }
            else if(left.val + right.val < target)
                left = iterleft.hasNext()? iterleft.next() : null;
            else
                right = iterright.hasNext()? iterright.next() : null;
        }

        return res;
    }
    public static TreeNode buildTree(Integer[] arr, int[] index){
        if(arr[ index[0] ] == null) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(arr[ index[0] ]);
        index[0]++;

        root.left = buildTree(arr, index);
        root.right = buildTree(arr, index);

        return root;
    }

    public static void main(String[] args){
        Integer[] arr = new Integer[]{9,2,1,null,null,7,null,null,18,17,null,null,21,null,null};
        TreeNode root = buildTree(arr, new int[]{0});

        TreeNode[] res = findPair(root, 24);
        System.out.println(res[0].val);
        System.out.println(res[1].val);
    }



}
class TreeIterator{
    final boolean normalOrder;
    TreeNode curNode;
    Deque<TreeNode> st = new LinkedList<>();
    public TreeIterator(TreeNode root, boolean normal){
        curNode = root;
        normalOrder = normal;
    }
    public boolean hasNext(){
        return curNode != null || !st.isEmpty();
    }
    public TreeNode next(){
        if(normalOrder){
            while(curNode != null){
                st.push(curNode);
                curNode = curNode.left;
            }
            TreeNode ret = st.pop();

            curNode = ret.right;
            return ret;
        }
        else{
            while(curNode != null){
                st.push(curNode);
                curNode = curNode.right;
            }
            TreeNode ret = st.pop();

            curNode = ret.left;
            return ret;
        }
    }
}


