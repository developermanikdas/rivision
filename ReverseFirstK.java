import java.util.*;

public class ReverseFirstK {
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) return q;

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // Step 2: Pop from stack and enqueue back
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Move remaining elements to back
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.poll());
        }

        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 10; i <= 100; i += 10) {
            q.add(i);
        }

        int k = 5;
        Queue<Integer> ans = modifyQueue(q, k);

        System.out.println(ans); // Output: [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
    }
}
