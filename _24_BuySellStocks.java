// can buy and sell stock only one time

public class _24_BuySellStocks {
    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Max profit : " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int max = prices[prices.length - 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(prices[i], max);
            profit = Math.max(max - prices[i], profit);
        }

        return profit;
    }
}
