public class maxSubArray {
    // Function to find the maximum subarray sum using Kadane's algorithm                                                                                                                       
    public static int findMaxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum (Example 1): " + findMaxSubArray(nums1));

        // Test Case 2
        int[] nums2 = {1};
        System.out.println("Maximum Subarray Sum (Example 2): " + findMaxSubArray(nums2));

        // Test Case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Maximum Subarray Sum (Example 3): " + findMaxSubArray(nums3));
    }

}