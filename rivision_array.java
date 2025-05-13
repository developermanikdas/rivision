
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

    public static void printSubarray(){
        
    }
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 7, 8, 9 };

        // binary Search function call 👇👇👇
        // int binarySearchResult = binarySearch(arr, 1);
        // if (binarySearchResult != -1) {
        //     System.out.println("The target is found at index " + binarySearchResult);
        // } else {
        //     System.out.println("The target is not found");
        // }


        // reverse an array 👇👇👇
        // reverseArray(arr);
        // for(int i : arr){
        //     System.out.println(i);
        // }





    }
}