public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;

            currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(temp * nums[i], currentMin * nums[i]));

            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray (Example 1): " + maxProduct(nums1)); // Output: 6

        // Example 2
        int[] nums2 = {-2, 0, -1};
        System.out.println("Maximum Product Subarray (Example 2): " + maxProduct(nums2)); // Output: 0
    }
}
