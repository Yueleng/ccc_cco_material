import java.util.LinkedList;
import java.util.Random;
// Invariant: 
//   If a node value exists on current level, it must exists on next level;
public class Skiplist {

    class Node {
        int val;
        Node right;
        Node down;

        public Node() {
            this.val = -1;
            this.right = null;
            this.down = null;
        }

        public Node(int val, Node right, Node down) {
            this.val = val;
            this.right = right;
            this.down = down;
        }
    }


    private Node head;
    Random rd = new Random();

    public Skiplist() {
        // Dummy Head;
        this.head = new Node();
    }

    public boolean search(int target) {
        Node node = this.head;

        while (node != null) {
            // Move to the right in the current level
            while (node.right != null && node.right.val < target)
                node = node.right;
            
            
            if (node.right != null && node.right.val == target)
                return true;
            
            // Move to the next level
            node = node.down;
        }

        return false;
    }

    public boolean erase(int num) {
        Node node = this.head;
        boolean found = false;

        while (node != null) {
            // Move to the right in the current level
            while (node.right != null && node.right.val < num)
                node = node.right;
            
            // Find the target node
            if (node.right != null && node.right.val == num) {
                // Delete by skipping
                node.right = node.right.right;
                found = true;
            }

            // Move to the next level
            node = node.down;
        }

        return found;
    }

    public void add(int num) {
        LinkedList<Node> nodes = new LinkedList<Node>();
        Node node = this.head;

        while (node != null) {
            // Move to the right in the current level
            while (node.right != null && node.right.val < num)
                node = node.right;
            
            nodes.add(node);
            // Move to the next level
            node = node.down;
        }

        boolean insert = true;
        Node down = null;

        // Bottom up
        while (insert && nodes.size() > 0) {
            node = nodes.removeLast();
            node.right = new Node(num, node.right, down);
            down = node.right;
            insert = rd.nextBoolean(); // prob 1/2 = false and prob 1/2 = true;
        }

        // Create a new level with a dummy head;
        // right = null
        // down = current head
        if (insert)
            this.head = new Node(-1, null, this.head);

    }
}
