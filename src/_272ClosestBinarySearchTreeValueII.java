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


    //////////    O ( k )  solution
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
//        closestKValues1(root, target, k);

        Deque<TreeNode> lessThan = new LinkedList<>();
        Deque<TreeNode> greater = new LinkedList<>();
        TreeNode curnode = root;
        while(curnode != null){
            if(curnode.val <= target){
                lessThan.push(curnode);
                curnode = curnode.right;
            }
            else{
                greater.push(curnode);
                curnode = curnode.left;
            }
        }

        List<Integer> less = new LinkedList<>();
        List<Integer> more = new LinkedList<>();

        while( !lessThan.isEmpty() )
            inorder(less, lessThan.pop(), true, k);

        while( !greater.isEmpty() )
            inorder(more, greater.pop(), false, k);

        List<Integer> res = new LinkedList<>();
        while(res.size() < k){

            if(less.size() == 0 )
                res.add( more.remove(0) );
            else if(more.size() == 0)
                res.add( less.remove(0) );
            else{
                if( Math.abs( less.get(0) - target ) > Math.abs(more.get(0) - target ) )
                    res.add(more.remove(0));
                else
                    res.add(less.remove(0));
            }
        }
        return res;
    }
    private void inorder(List<Integer> ls, TreeNode root, boolean reverse, int k){
        if(ls.size() >= k)
            return;
        TreeNode backRoot = root;
        TreeNode backConnect = reverse? root.right : root.left;

        if(reverse)
            root.right = null; // This direction get wrong // root.left = null;
        else
            root.left = null;

        Deque<TreeNode> st = new LinkedList<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = reverse ? root.right : root.left;
            }

            TreeNode visit = st.pop();
            ls.add(visit.val);
            root = reverse? visit.left : visit.right;

            if(ls.size() >= k)
                break;
        }

        if(reverse)
            backRoot.right = backConnect;
        else
            backRoot.left = backConnect;
    }

}
