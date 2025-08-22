import java.util.*;

public class NextGreaterElementI2 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    // Test the function
    public static void main(String[] args) {
        int[] nums1_1 = {4, 1, 2};
        int[] nums2_1 = {1, 3, 4, 2};

        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};

        System.out.println("Testcase 1 Result: " + Arrays.toString(nextGreaterElement(nums1_1, nums2_1))); // [-1, 3, -1]
        System.out.println("Testcase 2 Result: " + Arrays.toString(nextGreaterElement(nums1_2, nums2_2))); // [3, -1]
    }
}
