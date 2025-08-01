import java.util.Arrays;

public class CheckArithmeticProgression {
    public static boolean canFormAP(int[] arr) {
        int n = arr.length;

        // An array with 0 or 1 elements is trivially an AP
        if (n <= 2) return true;

        // Sort the array
        Arrays.sort(arr);

        // Find common difference
        int diff = arr[1] - arr[0];

        // Check for AP property
        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1};  // Sample input
        boolean result = canFormAP(arr);
        System.out.println("Can form AP? " + result);
    }
}
