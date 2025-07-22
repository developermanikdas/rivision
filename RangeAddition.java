import java.util.Arrays;

public class RangeAddition {
    public static int[] getModifiedArray(int n, int[][] updates) {
        int[] result = new int[n];

        // Apply the difference array logic
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            result[start] += inc;
            if (end + 1 < n) {
                result[end + 1] -= inc;
            }
        }

        // Build the final array using prefix sum
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] updates = {
            {1, 3, 2},
            {2, 4, 3},
            {0, 2, -2}
        };

        int[] result = getModifiedArray(n, updates);
        System.out.println("Modified array: " + Arrays.toString(result));
    }
}
