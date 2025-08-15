import java.util.*;

public class FindMedianFromDataStream {
    // Max-heap for the smaller half
    private PriorityQueue<Integer> maxHeap;
    // Min-heap for the larger half
    private PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to maxHeap first
        maxHeap.offer(num);
        // Step 2: Move the largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());
        // Step 3: Balance heaps (maxHeap can be bigger by 1)
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    // Testcase
    public static void main(String[] args) {
        FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median after adding 1, 2: " + medianFinder.findMedian()); // 1.5

        medianFinder.addNum(3);
        System.out.println("Median after adding 3: " + medianFinder.findMedian()); // 2.0

        medianFinder.addNum(5);
        medianFinder.addNum(4);
        System.out.println("Median after adding 5, 4: " + medianFinder.findMedian()); // 3.0
    }
}
