/**
 * Created by weihengwang on 6/20/17.
 */
public class _206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dum = new ListNode(0);
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur;
            cur = cur.next;

            tmp.next = dum.next;
            dum.next = tmp;
        }
        return dum.next;
    }
    // public ListNode reverseList(ListNode head) {
    //     if(head == null || head.next == null)
    //         return head;
    //     ListNode dum = new ListNode(0);
    //     helper(head, dum);
    //     return dum.next;
    // }
    // private ListNode helper(ListNode head, ListNode dum){
    //     if(head.next == null){
    //         dum.next = head;
    //         return head;
    //     }
    //     ListNode tail = helper(head.next, dum);
    //     tail.next = head;
    //     head.next = null;

    //     return head;
    // }
}
