import java.util.*;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // sum 0 has one occurrence to handle subarray starting at index 0

        int count = 0, currSum = 0;

        for (int num : nums) {
            currSum += num;

            // If there's a prefix sum such that currSum - prefix = k
            if (prefixMap.containsKey(currSum - k)) {
                count += prefixMap.get(currSum - k);
            }

            // Store current sum into map
            prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
