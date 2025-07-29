public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(obj.singleNumber(nums)); // Output: 4
    }
}
