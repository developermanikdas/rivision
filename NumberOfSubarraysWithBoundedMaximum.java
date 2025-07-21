public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countSubarrays(nums, right) - countSubarrays(nums, left - 1);
    }

    private int countSubarrays(int[] nums, int bound) {
        int count = 0, result = 0;
        for (int num : nums) {
            if (num <= bound) {
                count++;
            } else {
                count = 0;
            }
            result += count;
        }
        return result;
    }
}
