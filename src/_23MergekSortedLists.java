import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by weihengwang on 3/21/17.
 */
public class _23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode app = head;
        PriorityQueue<ListNode> pq = new PriorityQueue(10, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        for(ListNode ls : lists){
            pq.offer(ls);
        }

        while(pq.isEmpty() == false){
            ListNode cur = pq.poll();
            app.next = cur;
            cur = cur.next;
            app = app.next;
            app.next = null;

            if(cur != null)
                pq.offer(cur);
        }
        return head.next;
    }
}
