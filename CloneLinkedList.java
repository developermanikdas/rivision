class Node {
    int val;
    Node next, random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CloneLinkedList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes in between
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        while (curr != null) {
            Node front = curr.next.next;

            // extract the copy
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;

            // restore original list
            curr.next = front;
            curr = front;
        }

        return dummy.next;
    }
}
