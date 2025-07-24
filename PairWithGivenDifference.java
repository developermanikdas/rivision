import java.util.*;

public class PairWithGivenDifference {
    public static boolean hasPairWithDifference(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num + k) || set.contains(num - k)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 20, 3, 2, 50, 80};
        int k = 78;

        boolean result = hasPairWithDifference(nums, k);
        System.out.println(result);  // Output: true
    }
}
