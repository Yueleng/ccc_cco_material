import java.util.HashMap;

class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1)); // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2)); // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1)); // return -1 (not found)
        System.out.println(lRUCache.get(3)); // return 3
        System.out.println(lRUCache.get(4)); // return 4
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;

        // null <= head <=> tail => null
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;

        // null <= head <=> node1 <=> node2 ... <=> tail => null
        // add newNode to this Double Linked List
        // node.pre = head; -> head <= node
        // node.post = head.post -> head <= node => node1
        // head.post.pre = node -> head <= node <=> node1
        // head.post = node; -> head <=> node <=> node1
        // Result:
        // null <= head <=> newNode <=> node1 <=> node2 ... <=> tail => null
    }

    /**
     * Move certain node in between to the head
     * 
     * @param node
     */

    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // Remove an existing node from the double linked list;
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    // Pop the current tail
    private DLinkedNode popTail() {
        DLinkedNode node = tail.pre;
        this.removeNode(node);
        return node;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // if not exist in the cache<Integer, DLinkedNode>, return -1;
        }

        // Move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            // key not in cache<Integer, DLinkedNode> yet.
            // 1. Construct new node
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);

            count++;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }

        } else {
            // key in cache<Integer, DLinkedNode>.
            // 1. Update Value: node.value = value,
            // 2. Move this node to the head
            node.value = value;
            this.moveToHead(node);
        }

    }

}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */