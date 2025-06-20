public class MaxCircularSubarray {
    public static int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0], curMax = 0;
        int minSum = nums[0], curMin = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);

            total += num;
        }

        // If all numbers are negative, maxWrap would be 0 → wrong
        return (maxSum > 0) ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println("Max Circular Subarray Sum: " + maxSubarraySumCircular(nums));  // Output: 10
    }
}
