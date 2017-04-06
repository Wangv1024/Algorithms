/**
 * Created by weihengwang on 2/16/17.
 */
public class _2AddTwoNumbers {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode newhead = new ListNode(0);
//        ListNode curnode = newhead;
//        int carry = 0;
//        while(l1 != null || l2 != null || carry != 0){
//            int add1 = l1 == null ? 0 : l1.val;
//            int add2 = l2 == null ? 0 : l2.val;
//
//            int sum = add1 + add2 + carry;
//            curnode.next = new ListNode(sum % 10);
//            carry = sum / 10;
//
//            curnode = curnode.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        return newhead.next;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while( l1 != null || l2 != null){
            int l1val = 0;
            if(l1 != null){
                l1val = l1.val;
                l1 = l1.next;
            }
            int l2val = 0;
            if(l2 != null){
                l2val = l2.val;
                l2 = l2.next;
            }
            int sum = carry + l1val + l2val;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }
        if(carry != 0)
            cur.next = new ListNode(carry);

        return head.next;
    }
}
