import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length < 2) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.offer(stick);
        }

        int totalCost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            totalCost += cost;
            minHeap.offer(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        MinimumCostToConnectSticks sol = new MinimumCostToConnectSticks();
        int[] sticks = {2, 4, 3, 1};
        System.out.println(sol.connectSticks(sticks)); // Output: 19
    }
}
