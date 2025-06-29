public class MaxSubarrayWithOneDeletion {
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int[] forward = new int[n];  // max subarray sum ending at or before i
        int[] backward = new int[n]; // max subarray sum starting at or after i

        forward[0] = arr[0];
        int maxSum = arr[0];

        // Forward pass (standard Kadane)
        for (int i = 1; i < n; i++) {
            forward[i] = Math.max(arr[i], forward[i - 1] + arr[i]);
            maxSum = Math.max(maxSum, forward[i]);
        }

        // Backward pass (reversed Kadane)
        backward[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            backward[i] = Math.max(arr[i], backward[i + 1] + arr[i]);
        }

        // Try deleting one element and combining max subarrays on both sides
        for (int i = 1; i < n - 1; i++) {
            int withOneDeletion = forward[i - 1] + backward[i + 1];
            maxSum = Math.max(maxSum, withOneDeletion);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 0, 3};
        System.out.println("Maximum Sum with One Deletion: " + maximumSum(arr));
    }
}
