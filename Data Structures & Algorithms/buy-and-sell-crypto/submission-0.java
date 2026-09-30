class Solution {
    public int maxProfit(int[] prices) {

        int l = 0; // buy day
        int r = 1; // sell day
        int profit = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                if (prices[r] - prices[l] > profit) {
                    profit = prices[r] - prices[l];
                }
            } else {
                l = r; // l pointer becomes r pointer since prices[r] is the lowest prices in the current loop iteration 
            }
            r++;
        }
        return profit;
    }
}
