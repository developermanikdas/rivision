public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // First appearance: add to ones
            // Second appearance: remove from ones, add to twos
            // Third appearance: remove from both
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;  // The number that appears once
    }

    public static void main(String[] args) {
        SingleNumberII obj = new SingleNumberII();
        
        // Test case 1: [2,2,3,2] -> 3
        int[] nums1 = {2, 2, 3, 2};
        System.out.println("Single number in [2,2,3,2]: " + obj.singleNumber(nums1));
        
        // Test case 2: [0,1,0,1,0,1,99] -> 99
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Single number in [0,1,0,1,0,1,99]: " + obj.singleNumber(nums2));
        
        // Test case 3: [30000,500,100,30000,100,30000,100] -> 500
        int[] nums3 = {30000, 500, 100, 30000, 100, 30000, 100};
        System.out.println("Single number in [30000,500,100,30000,100,30000,100]: " + obj.singleNumber(nums3));
    }
}
