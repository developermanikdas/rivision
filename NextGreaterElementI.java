import java.util.*;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store: element -> next greater element
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2
        for (int num : nums2) {
            // Maintain decreasing stack
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    // Quick test
    public static void main(String[] args) {
        NextGreaterElementI obj = new NextGreaterElementI();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1, nums2)));
        // Output: [-1, 3, -1]
    }
}
