/**
 * Created by weihengwang on 6/1/17.
 */
public class _147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode exp = head, insertp;
        while(exp.next != null){
            insertp = dummy;
            while(insertp.next.val < exp.next.val)
                insertp = insertp.next;
            if(insertp != exp){
                ListNode remove = exp.next;
                exp.next = exp.next.next;

                remove.next = insertp.next;
                insertp.next = remove;
            }
            else
                exp = exp.next;
        }
        return dummy.next;
    }
}
