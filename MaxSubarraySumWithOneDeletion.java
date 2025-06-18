import java.util.*;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);  // to count subarrays starting from index 0

        int count = 0;
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;

            // Check if there is a prefix that when removed gives sum = k
            if (prefixMap.containsKey(prefixSum - k)) {
                count += prefixMap.get(prefixSum - k);
            }

            // Update prefixMap
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        System.out.println("Total Subarrays with Sum = " + k + ": " + subarraySum(arr, k));  // Output: 4
    }
}
