import java.util.*;

public class SubarrayEqual0And1 {
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Prefix sum 0 at index -1

        int maxLen = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1
            prefixSum += (nums[i] == 0 ? -1 : 1);

            if (map.containsKey(prefixSum)) {
                // Found subarray with equal 0 and 1
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 1, 0};
        System.out.println("Length of largest subarray: " + findMaxLength(nums));
    }
}
