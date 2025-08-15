public class CapacityToShipWithinDDays {
    
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        // Minimum capacity = max weight, Maximum capacity = sum of all weights
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        // Binary search for the minimum valid capacity
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid; // Try smaller capacity
            } else {
                left = mid + 1; // Need more capacity
            }
        }

        return left;
    }

    // Helper method to check if we can ship within given days using given capacity
    private boolean canShip(int[] weights, int days, int capacity) {
        int dayCount = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                dayCount++;
                currentLoad = 0;
            }
            currentLoad += w;
        }

        return dayCount <= days;
    }

    // Testcase
    public static void main(String[] args) {
        CapacityToShipWithinDDays solver = new CapacityToShipWithinDDays();

        int[] weights1 = {1,2,3,4,5,6,7,8,9,10};
        int days1 = 5;
        System.out.println("Min capacity for example 1: " + solver.shipWithinDays(weights1, days1)); // 15

        int[] weights2 = {3,2,2,4,1,4};
        int days2 = 3;
        System.out.println("Min capacity for example 2: " + solver.shipWithinDays(weights2, days2)); // 6

        int[] weights3 = {1,2,3,1,1};
        int days3 = 4;
        System.out.println("Min capacity for example 3: " + solver.shipWithinDays(weights3, days3)); // 3
    }
}
