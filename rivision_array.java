import java.util.*;

class rivisionArray {

    public static int binarySearch(int arr[], int target) {

        int start = 0, end = arr.length - 1;

        while (start <= end) {

            // int mid = (start + end) / 2;
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void reverseArray(int arr[]) {

        int start = 0, end = arr.length - 1;

        while (start < end) {
            int temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }

    public static void printArrayPairs(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + " " + arr[j]);
            }
        }
    }

    public static int printSubarrayMaxBruteForce(int arr[]) {
        int maxSum = Integer.MIN_VALUE;

        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int curSum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    curSum += arr[k];
                }
                System.out.println("-> Sum: " + curSum);
                maxSum = Math.max(maxSum, curSum);
            }
        }
        System.out.println("Maximum Subarray Sum: " + maxSum);
        return maxSum;
    }
 
    public static int printSubarrayMaxPrefixSum(int[] arr){
        int length = arr.length; 
        int prfixArr[length] = new Array; 
        return 69;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 7 };

        // binary Search function call 👇👇👇
        // int binarySearchResult = binarySearch(arr, 1);
        // if (binarySearchResult != -1) {
        // System.out.println("The target is found at index " + binarySearchResult);
        // } else {
        // System.out.println("The target is not found");
        // }

        // reverse an array 👇👇👇
        // reverseArray(arr);
        // for(int i : arr){
        // System.out.println(i);
        // }

        // print array pairs 👇👇👇
        // printArrayPairs(arr);

        // print sub-array max 👇👇👇

        // printSubarrayMaxBrute(arr);👇👇👇

        

    }
}