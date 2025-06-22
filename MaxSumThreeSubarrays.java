import java.util.*;

public class MaxSumThreeSubarrays {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1]; // sum of every k-window
        int windowSum = 0;

        // Precompute k-window sums
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i >= k) windowSum -= nums[i - k];
            if (i >= k - 1) sum[i - k + 1] = windowSum;
        }

        // Left: best index with max sum from [0...i]
        int[] left = new int[sum.length];
        int bestLeft = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > sum[bestLeft]) bestLeft = i;
            left[i] = bestLeft;
        }

        // Right: best index with max sum from [i...end]
        int[] right = new int[sum.length];
        int bestRight = sum.length - 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[bestRight]) bestRight = i;
            right[i] = bestRight;
        }

        // Try every middle interval
        int[] res = new int[3];
        int maxTotal = 0;

        for (int mid = k; mid < sum.length - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];

            int total = sum[l] + sum[mid] + sum[r];
            if (total > maxTotal) {
                maxTotal = total;
                res[0] = l;
                res[1] = mid;
                res[2] = r;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int k = 2;
        System.out.println("Starting Indices: " + Arrays.toString(maxSumOfThreeSubarrays(nums, k)));
        // Output: [0, 3, 5]
    }
}