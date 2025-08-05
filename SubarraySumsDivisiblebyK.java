import java.util.HashMap;

public class SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        int result = subarraysDivByK(nums, k);
        System.out.println("Output: " + result);  // Expected: 7
    }

    public static int subarraysDivByK(int[] nums, int k) {
        // HashMap to store frequency of mod values
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Empty prefix sum

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            int mod = sum % k;

            // Handle negative mods (e.g., -2 % 5 = -2, but we want 3)
            if (mod < 0) mod += k;

            // If mod is already seen, increment count by frequency
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            // Update mod frequency in map
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
