public class MaxSubarraySumAfterOneFlip {
    public static int maxSubarraySumWithOneFlip(int[] arr) {
        int n = arr.length;

        int maxEndHere = arr[0];
        int maxSoFar = arr[0];

        int flipMaxEndHere = -arr[0]; // start by flipping first
        int flipMaxSoFar = flipMaxEndHere;

        for (int i = 1; i < n; i++) {
            maxEndHere = Math.max(arr[i], maxEndHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);

            flipMaxEndHere = Math.max(-arr[i], flipMaxEndHere + arr[i]);
            flipMaxSoFar = Math.max(flipMaxSoFar, flipMaxEndHere);
        }

        return Math.max(maxSoFar, flipMaxSoFar);
    }

    public static int longestSubarraySumLEK(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > k && left <= right) {
                sum -= arr[left++];
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -2, 0, 3 };
        System.out.println("Maximum sum after one flip: " + maxSubarraySumWithOneFlip(arr));
    }
}
