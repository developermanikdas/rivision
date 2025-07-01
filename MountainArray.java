public class MountainArray {
    public static int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        // Step 1: Longest Increasing Subsequence ending at each index
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Longest Decreasing Subsequence starting at each index
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Find the max valid mountain length
        int maxMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                maxMountain = Math.max(maxMountain, lis[i] + lds[i] - 1);
            }
        }

        return n - maxMountain; // Min removals = total length - max mountain
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println("Minimum Removals: " + minimumMountainRemovals(arr));
    }
}
