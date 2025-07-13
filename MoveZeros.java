public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Move non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill the rest with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        // Output the modified array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
