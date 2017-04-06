import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by weihengwang on 2/13/17.
 */
public class _445AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> de1 = new LinkedList<>();
        Deque<Integer> de2 = new LinkedList<>();
        while(l1 != null || l2 != null){
            if(l1 != null) {
                de1.push(l1.val);
                l1 = l1.next;
            }
            if(l2 != null) {
                de2.push(l2.val);
                l2 = l2.next;
            }

        }

        int carry = 0;
        ListNode head = null;
        while(de1.isEmpty() == false || de2.isEmpty() == false){
            int num1 = de1.isEmpty() ? 0 : de1.pop();
            int num2 = de2.isEmpty() ? 0 : de2.pop();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            ListNode newhead = new ListNode(sum % 10);
            newhead.next = head;
            head = newhead;
        }

        if(carry != 0){
            ListNode newhead = new ListNode(1);
            newhead.next = head;
            head = newhead;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
