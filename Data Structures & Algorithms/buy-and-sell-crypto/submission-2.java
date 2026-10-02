class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = Integer.MAX_VALUE;
        int maxP = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyDay) {
                buyDay = prices[i];
            } else if (prices[i] - buyDay > maxP) {
                maxP = prices[i] - buyDay;
            } 
        }
        return maxP;
    }
}
