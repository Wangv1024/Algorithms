import java.util.*;

/**
 * Created by weihengwang on 4/23/17.
 */
public class _272ClosestBinarySearchTreeValueII {
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> pre = new LinkedList<>();
        Deque<Integer> after = new LinkedList<>();
        inorder(root, target, pre, false);
        inorder(root, target, after, true);

        List<Integer> res = new ArrayList<>();
        while(k-- > 0){
            if(pre.isEmpty() && after.isEmpty())
                break;
            else if(pre.isEmpty() && !after.isEmpty()){
                res.add(after.pop());
            }
            else if(after.isEmpty() && !pre.isEmpty()){
                res.add(pre.pop());
            }
            else if(Math.abs(pre.peek() - target) > Math.abs(after.peek() - target) ){
                res.add(after.pop());
            }
            else
                res.add(pre.pop());
        }
        return res;
    }
    private static void inorder(TreeNode root, double target, Deque<Integer> st, boolean reverse){
        if(root == null)  // forget this part
            return;

        if(reverse)
            inorder(root.right, target, st, reverse);
        else
            inorder(root.left, target, st, reverse);

        if( reverse && root.val <= target )
            return;
        if( !reverse && root.val > target)
            return;

        st.push(root.val);

        if(reverse)
            inorder(root.left, target, st, reverse);
        else
            inorder(root.right, target, st, reverse);
    }
    public static void main(String[] args){
        int[] input = new int[]{6, 2, 1, -1, -1, 5, -1, -1, 8, 7, -1, -1, -1};
        TreeNode root =  buildTree(input, new int[1]);

        System.out.println(closestKValues(root, 4.9, 3));

    }
    public static TreeNode buildTree(int[] input, int[] glob){
        if(input[ glob[0] ] == -1){
            glob[0]++;
            return null;
        }
        TreeNode root = new TreeNode(input[ glob[0] ]);
        glob[0] ++;

        root.left = buildTree(input, glob);
        root.right = buildTree(input, glob);

        return root;
    }
}
