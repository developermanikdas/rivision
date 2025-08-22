import java.util.*;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n ? 0 : heights[i]);
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    // Test the function
    public static void main(String[] args) {
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int[] heights2 = {2, 4};
        int[] heights3 = {6, 2, 5, 4, 5, 1, 6};

        System.out.println("Testcase 1 Result: " + largestRectangleArea(heights1)); // 10
        System.out.println("Testcase 2 Result: " + largestRectangleArea(heights2)); // 4
        System.out.println("Testcase 3 Result: " + largestRectangleArea(heights3)); // 12
    }
}
