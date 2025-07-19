class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();

        int i = digits.length - 2;
        // Step 1: Find the pivot
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no pivot found, return -1
        if (i < 0) return -1;

        // Step 2: Find the next bigger digit to the right of the pivot
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap pivot with next greater digit
        swap(digits, i, j);

        // Step 4: Reverse everything after the pivot
        reverse(digits, i + 1, digits.length - 1);

        // Step 5: Convert back to integer
        long result = Long.parseLong(new String(digits));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
