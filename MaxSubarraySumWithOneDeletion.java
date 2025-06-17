public class MaxSubarraySumWithOneDeletion {
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int max = arr[0];

        int[] noDelete = new int[n];  // f[i]
        int[] oneDelete = new int[n]; // g[i]

        noDelete[0] = arr[0];
        oneDelete[0] = 0;

        for (int i = 1; i < n; i++) {
            noDelete[i] = Math.max(noDelete[i - 1] + arr[i], arr[i]);
            oneDelete[i] = Math.max(oneDelete[i - 1] + arr[i], noDelete[i - 1]);
            max = Math.max(max, Math.max(noDelete[i], oneDelete[i]));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 0, 3};
        System.out.println("Max Sum With One Deletion: " + maximumSum(arr));  // Output: 4
    }
}
