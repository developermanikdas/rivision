public class BuySellStockII {
    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If price goes up from yesterday, we take the profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public class BuySellStockIII {
        public static int maxProfit(int[] prices) {
            if (prices.length == 0)
                return 0;

            int n = prices.length;
            int[] left = new int[n]; // Max profit if sold up to day i
            int[] right = new int[n]; // Max profit if bought from day i

            // Left pass
            int minLeft = prices[0];
            for (int i = 1; i < n; i++) {
                minLeft = Math.min(minLeft, prices[i]);
                left[i] = Math.max(left[i - 1], prices[i] - minLeft);
            }

            // Right pass
            int maxRight = prices[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                maxRight = Math.max(maxRight, prices[i]);
                right[i] = Math.max(right[i + 1], maxRight - prices[i]);
            }

            // Combine
            int maxProfit = 0;
            for (int i = 0; i < n; i++) {
                maxProfit = Math.max(maxProfit, left[i] + right[i]);
            }

            return maxProfit;
        }

        public static void main(String[] args) {
            int[] prices = { 7, 1, 5, 3, 6, 4 };
            System.out.println("Maximum Profit: " + maxProfit(prices));
        }

    }

}
