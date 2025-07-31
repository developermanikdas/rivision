public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {
        int xor = 0;

        // Step 1: XOR all numbers to get x ^ y (the two unique numbers)
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find the rightmost set bit (bit that differs between x and y)
        int diff = xor & -xor;

        int x = 0, y = 0;

        // Step 3: Partition numbers based on the set bit
        for (int num : nums) {
            if ((num & diff) == 0) {
                x ^= num;  // one group
            } else {
                y ^= num;  // other group
            }
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = singleNumber(nums);

        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }
}
