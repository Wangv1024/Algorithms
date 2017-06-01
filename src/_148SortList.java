/**
 * Created by weihengwang on 6/1/17.
 */
public class _148SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        return mergesort(head);
    }
    private ListNode mergesort(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode divd = slow.next;
        slow.next = null;
        ListNode h1 = mergesort(head);
        ListNode h2 = mergesort(divd);
        return merge(h1, h2);
    }
    private ListNode merge(ListNode h1, ListNode h2){
        ListNode dum = new ListNode(0);
        ListNode res = dum;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                dum.next = h1;
                h1 = h1.next;
            }
            else {
                dum.next = h2;
                h2 = h2.next;
            }
            dum = dum.next;
            dum.next = null;
        }
        if(h1 != null)
            dum.next = h1;
        else
            dum.next = h2;
        return res.next;
    }
}
