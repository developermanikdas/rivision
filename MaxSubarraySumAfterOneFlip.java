 import java.util.*;
public class MaxSubarraySumAfterOneFlip {
    public static int maxSubarraySumWithOneFlip(int[] arr) {
        int n = arr.length;

        int maxEndHere = arr[0];
        int maxSoFar = arr[0];

        int flipMaxEndHere = -arr[0]; // start by flipping first
        int flipMaxSoFar = flipMaxEndHere;

        for (int i = 1; i < n; i++) {
            maxEndHere = Math.max(arr[i], maxEndHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);

            flipMaxEndHere = Math.max(-arr[i], flipMaxEndHere + arr[i]);
            flipMaxSoFar = Math.max(flipMaxSoFar, flipMaxEndHere);
        }

        return Math.max(maxSoFar, flipMaxSoFar);
    }

    public static int longestSubarraySumLEK(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > k && left <= right) {
                sum -= arr[left++];
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int prod = 1, left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];

            while (prod >= k) {
                prod /= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }

   

public static int shortestSubarray(int[] nums, int k) {
    int n = nums.length;
    long[] prefix = new long[n + 1];
    for (int i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

    int minLen = n + 1;
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i <= n; i++) {
        while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
            minLen = Math.min(minLen, i - deque.pollFirst());
        }

        while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
            deque.pollLast();
        }

        deque.offerLast(i);
    }

    return minLen <= n ? minLen : -1;
}

   

    public static int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        Deque<int[]> deque = new ArrayDeque<>();

        for (int[] point : points) {
            int x = point[0], y = point[1];

            while (!deque.isEmpty() && x - deque.peekFirst()[1] > k) {
                deque.pollFirst();
            }

            if (!deque.isEmpty()) {
                max = Math.max(max, x + y + deque.peekFirst()[0]);
            }

            // Keep deque in decreasing order of (y - x)
            while (!deque.isEmpty() && (y - x) >= deque.peekLast()[0]) {
                deque.pollLast();
            }

            deque.offerLast(new int[] { y - x, x });
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -2, 0, 3 };
        System.out.println("Maximum sum after one flip: " + maxSubarraySumWithOneFlip(arr));
    }
}
