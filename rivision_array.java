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

    public static int maxSubarraySumPrefix(int[] arr) {
        int n = arr.length;

        int[] prefixArr = new int[n];
        prefixArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int curSum = i == 0 ? prefixArr[j] : prefixArr[j] - prefixArr[i - 1];
                maxSum = Math.max(curSum, maxSum);
                System.out.println(" Current Sum is: -> " + curSum);
            }
        }

        System.out.println("Max Sum is: -> " + maxSum);

        return maxSum;
    }

    public static void kadaneAlgorithm(int arr[]) {
        int n = arr.length;

        int curSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curSum = curSum + arr[i];
            maxSum = Math.max(curSum, maxSum);

            if (curSum < 0) {
                curSum = 0;
            }
        }
        System.out.println("Max Subarray Sum is: " + maxSum);
    }

    public static void main(String[] args) {
        int arr[] = { 1, -13, 5, 7 };

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

        // printSubarrayMaxBrute(arr);

        // maxSubarraySumPrefix(arr);

        // System.out.println(maxSubArray(arr));
        // maxSubarraySumPrefix(arr);
        // kadaneAlgorithm(arr);

    }
}