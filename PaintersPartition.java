public class PaintersPartition {

    public static int minTime(int[] boards, int k) {
        int low = 0, high = 0;
        
        // Low = max board length, High = sum of all boards
        for (int len : boards) {
            low = Math.max(low, len);
            high += len;
        }
        
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(boards, k, mid)) {
                result = mid;
                high = mid - 1; // try smaller maximum
            } else {
                low = mid + 1;  // need bigger maximum
            }
        }
        
        return result;
    }
    
    private static boolean isPossible(int[] boards, int k, int maxAllowed) {
        int painterCount = 1;
        int currSum = 0;
        
        for (int len : boards) {
            if (currSum + len <= maxAllowed) {
                currSum += len;
            } else {
                painterCount++;
                currSum = len;
                if (painterCount > k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int k = 2;
        System.out.println("Minimum time: " + minTime(boards, k));
    }
}
