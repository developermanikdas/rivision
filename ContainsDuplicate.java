import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Found a duplicate
            }
            seen.add(num); // Add number to set
        }

        return false; // All elements are unique
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Contains Duplicate? " + containsDuplicate(nums));
    }
}
