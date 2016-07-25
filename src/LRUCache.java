import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 28/6/2016.
 */
public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node currentNode = map.get(key);
        Node prev = currentNode.prev;
        Node next = currentNode.next;
        prev.next = next;
        next.prev = prev;

        moveToTail(currentNode);
        return map.get(key).value;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
        } else {
            if (map.size() == capacity) {
                // remove the first Node
                Node currentNode = head.next;
                Node prev = currentNode.prev;
                Node next = currentNode.next;
                prev.next = next;
                next.prev = prev;
                map.remove(currentNode.key);
            }

            // add the new node to the tail
            Node newNode = new Node(key, value);
            moveToTail(newNode);
            map.put(key, newNode);
        }
    }

    private void moveToTail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }

    /**
     *
     * 2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
     Output:
     [1,-1]
     Expected:
     [-1,3]
     *
     */
}
