public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;

        // Step 1: Find the first decreasing digit from the right
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such digit is found, it's the highest permutation already
        if (i == -1) return -1;

        // Step 2: Find the smallest digit greater than digits[i] to the right
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap the two digits
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Reverse the subarray to the right of i
        reverse(digits, i + 1, digits.length - 1);

        // Step 5: Convert to long to avoid overflow
        long val = Long.parseLong(new String(digits));
        return (val > Integer.MAX_VALUE) ? -1 : (int) val;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
