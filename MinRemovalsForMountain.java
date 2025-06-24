public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int currMax = nums[0], currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;

            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));

            maxProd = Math.max(maxProd, currMax);
        }

        return maxProd;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println("Max Product Subarray: " + maxProduct(nums));  // Output: 24
    }
}
