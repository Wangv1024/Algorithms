import java.util.HashMap;

/**
 * Created by weihengwang on 2/13/17.
 */
public class _138CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode copyhead = new RandomListNode(head.label);
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, copyhead);
        RandomListNode curnode = head;
        while(curnode != null){
            if(curnode.next != null) {
                if (map.containsKey(curnode.next) == false) {
                    RandomListNode nextnode = new RandomListNode(curnode.next.label);
                    map.put(curnode.next, nextnode);
                    map.get(curnode).next = nextnode;
                }
                else
                    map.get(curnode).next = map.get(curnode.next);
            }
            if(curnode.random != null) {
                if (map.containsKey(curnode.random) == false) {
                    RandomListNode randomNode = new RandomListNode(curnode.random.label);
                    map.put(curnode.random, randomNode);
                    map.get(curnode).random = randomNode;
                }
                else
                    map.get(curnode).random = map.get(curnode.random);
            }

            curnode = curnode.next;
        }

        return map.get(head);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}