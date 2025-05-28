public class rivision_basic_array_sorting {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element is greater than the next
                if (arr[j] > arr[j + 1]) {
                    // Swapping elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true; // A swap happened
                }
            }

            // Optimization: if no two elements were swapped in the inner loop, break early
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2 };
        bubbleSort(arr);
    }
}