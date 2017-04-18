/**
 * Created by weihengwang on 4/9/17.
 */
public class _61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode curn = head;
        int len = 0;
        while(curn != null){
            len++;
            curn = curn.next;
        }

        k = k % len;
        curn = head;
        ListNode slow = head;
        int count = 0;
        while( count < k ){
            curn = curn.next;
            count ++;
        }
        while(curn.next != null){
            curn = curn.next;
            slow = slow.next;
        }

        ListNode fakeh = new ListNode(0);
        ListNode appendp = fakeh;
        fakeh.next = slow.next;
        slow.next = null;
        while(appendp.next != null)
            appendp = appendp.next;

        appendp.next = head;

        return fakeh.next;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        int size =1;
        ListNode listNode = head;
        while(listNode.next != null){
            size++;
            listNode = listNode.next;
        }
        ListNode tail = listNode;
        k = k%size;
        if(k==0)
            return head;

        int step = size - k - 1;
        listNode = head;
        while(step>0) {
            listNode = listNode.next;
            step--;
        }

        tail.next = head;
        head = listNode.next;
        listNode.next = null;
        return head;
    }
}
