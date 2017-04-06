import java.util.HashMap;

/**
 * Created by weihengwang on 2/15/17.
 */
public class _146LRUCache {
    HashMap<Integer, DoubleLinkedNode> keymap;
    DoubleLinkedNode head, tail;
    int capa, size;
    public _146LRUCache(int capacity) {
        capa = capacity;
        if(capa <= 0)
            return;
        size = 0;
        keymap = new HashMap<>();
        head = new DoubleLinkedNode(0, 0);
        tail = new DoubleLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(capa <= 0)
            return Integer.MIN_VALUE;
        if(keymap.containsKey(key) == false)
            return -1;
        DoubleLinkedNode resNode = keymap.get(key); // hashmap .get can be empty!!
        remove(resNode);
        insertAfterhead(resNode);
        return resNode.val;
    }

    public void put(int key, int value) {
        if(capa <= 0)
            return;
        if(keymap.containsKey(key) == true){
            DoubleLinkedNode oldnode = keymap.get(key);
            oldnode.val = value;
            remove(oldnode);
            insertAfterhead(oldnode);
        }
        else{
            DoubleLinkedNode newnode = new DoubleLinkedNode(key, value);
            keymap.put(key, newnode);
            insertAfterhead(newnode);

            if(size >= capa){
                keymap.remove(tail.prev.key);
                removeLast();
            }
            else // size < capa
                size++;
        }

    }
    private DoubleLinkedNode removeLast(){
        DoubleLinkedNode dnode = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;

        dnode.next = null;
        dnode.prev = null;
        return dnode;
    }

    private void remove(DoubleLinkedNode dnode){
        dnode.prev.next = dnode.next;
        dnode.next.prev = dnode.prev;

        dnode.prev = null;
        dnode.next = null;
    }

    private void insertAfterhead(DoubleLinkedNode insnode){
        head.next.prev = insnode;
        insnode.next = head.next;
        head.next = insnode;
        insnode.prev = head;
    }

}
class DoubleLinkedNode {
    DoubleLinkedNode prev;
    DoubleLinkedNode next;
    int val;
    int key;
    public DoubleLinkedNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}
