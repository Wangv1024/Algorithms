/**
 * Created by weihengwang on 6/1/17.
 */
public class reverseLinkedList {
    public ListNode reverseLinkedListRecursize(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode dum = new ListNode(0);
        recursizeReverse(dum, head);
        return dum.next;
    }
    private ListNode recursizeReverse(ListNode dum, ListNode head){
        if(head.next == null){
            dum.next = head;
            return head;
        }
        ListNode tail = recursizeReverse(dum, head.next);
        head.next = null;
        tail.next = head;

        return head;
    }
    public static void main(String[] args){
        reverseLinkedList obj = new reverseLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        ListNode head = obj.reverseLinkedListRecursize(node);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
