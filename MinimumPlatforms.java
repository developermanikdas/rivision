import java.util.Arrays;

public class MinimumPlatforms {
    public static int findMinPlatforms(int[] arr, int[] dep) {
        int n = arr.length;

        // Sort arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1; // At least one platform needed initially
        int maxPlatforms = 1;
        int i = 1; // Pointer for next train arrival
        int j = 0; // Pointer for next train departure

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                // Next train arrives before the current one departs
                platforms++;
                i++;
            } else {
                // Current train departs before next arrives
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Minimum platforms required = " + findMinPlatforms(arr, dep));
    }
}
