import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Base case
        if (lists == null || lists.length == 0) return null;

        // Min-heap to sort nodes by their value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add the head of each list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Dummy node to build the final list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Keep extracting the smallest node and attach to result
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}
