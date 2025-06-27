public class MaxSubarraySumOneFlip {

    public static int maxSumAfterOneFlip(int[] nums) {
        int n = nums.length;

        // Track max sum ending here without and with flip
        int noFlip = nums[0];
        int oneFlip = -nums[0]; // we flip the first element
        int maxSum = Math.max(noFlip, oneFlip);

        for (int i = 1; i < n; i++) {
            // Normal Kadane's step (no flip)
            noFlip = Math.max(nums[i], noFlip + nums[i]);

            // Either flip current or extend a previous oneFlip subarray
            oneFlip = Math.max(noFlip - nums[i], oneFlip + nums[i]);

            maxSum = Math.max(maxSum, Math.max(noFlip, oneFlip));
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 0, 3};
        System.out.println("Max Subarray Sum After One Flip: " + maxSumAfterOneFlip(nums));
    }
}
