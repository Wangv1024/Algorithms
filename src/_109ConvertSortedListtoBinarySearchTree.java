/**
 * Created by weihengwang on 4/17/17.
 */
public class _109ConvertSortedListtoBinarySearchTree {
    ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        int count = 0;
        ListNode tmp = head;
        while(tmp != null){
            count ++;
            tmp = tmp.next;
        }
        current = head;
        return helper(1, count);
    }
    private TreeNode helper(int st, int end){
        if(st > end)
            return null;

        int mid = st + ( end - st ) / 2;
        TreeNode left = helper(st, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(mid + 1, end);

        root.left = left;
        root.right = right;
        return root;
    }
}
