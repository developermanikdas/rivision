import java.util.*;

public class AllocateBooks {

    // Feasibility: can we allocate with max pages per student <= limit using at most m students?
    private static boolean canAllocate(int[] pages, int m, int limit) {
        int students = 1;
        int sum = 0;

        for (int p : pages) {
            if (p > limit) return false; // single book exceeds limit: impossible
            if (sum + p <= limit) {
                sum += p;
            } else {
                students++;
                sum = p;
                if (students > m) return false;
            }
        }
        return true;
    }

    // Returns minimal possible maximum pages; -1 if impossible
    public static int allocate(int[] pages, int m) {
        int n = pages.length;
        if (m > n) return -1;

        int low = 0, high = 0;
        for (int p : pages) {
            low = Math.max(low, p);
            high += p;
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAllocate(pages, m, mid)) {
                ans = mid;
                high = mid - 1;      // try to minimize further
            } else {
                low = mid + 1;       // need a larger capacity
            }
        }
        return ans;
    }

    // Demo
    public static void main(String[] args) {
        int[] pages1 = {12, 34, 67, 90};
        int m1 = 2; // Expected: 113
        System.out.println("Min max pages: " + allocate(pages1, m1));

        int[] pages2 = {5, 17, 100, 11};
        int m2 = 4; // Each gets one -> 100
        System.out.println("Min max pages: " + allocate(pages2, m2));

        int[] pages3 = {10, 20, 30, 40};
        int m3 = 5; // Impossible (students > books) -> -1
        System.out.println("Min max pages: " + allocate(pages3, m3));
    }
}
