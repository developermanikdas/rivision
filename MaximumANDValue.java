public class MaximumANDValue {

    public static int maxAND(int[] arr) {
        int result = 0;

        // Try to set each bit from 31 to 0
        for (int bit = 31; bit >= 0; bit--) {
            int temp = result | (1 << bit);
            int count = countWithPattern(arr, temp);

            // If at least two numbers have this pattern, keep it
            if (count >= 2) {
                result = temp;
            }
        }

        return result;
    }

    private static int countWithPattern(int[] arr, int pattern) {
        int count = 0;
        for (int num : arr) {
            if ((num & pattern) == pattern) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 8, 6, 2};
        int[] arr2 = {10, 15, 5, 6};

        System.out.println("Max AND value in arr1: " + maxAND(arr1)); // Output: 4
        System.out.println("Max AND value in arr2: " + maxAND(arr2)); // Output: 14
    }
}
