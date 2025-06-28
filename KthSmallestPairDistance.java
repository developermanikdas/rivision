import java.util.Arrays;

public class KthSmallestPairDistance {

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array first
        int n = nums.length;

        // Binary search on the possible distance range
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = countPairs(nums, mid);

            if (count < k) {
                left = mid + 1; // Too few pairs, increase distance
            } else {
                right = mid; // Enough pairs, try smaller distance
            }
        }

        return left;
    }

    // Count how many pairs have distance <= mid
    private static int countPairs(int[] nums, int maxDist) {
        int count = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDist) {
                left++;
            }
            count += right - left;
        }

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        int k = 1;
        System.out.println("K-th smallest distance: " + smallestDistancePair(nums, k));
    }
}
