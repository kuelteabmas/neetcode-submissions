class Solution {
    public int maxProfit(int[] prices) {
        int buyDayPrice = Integer.MAX_VALUE;
        int maxP = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < buyDayPrice) {
                buyDayPrice = prices[i];
            } else if (prices[i] - buyDayPrice > maxP) {
                maxP = prices[i] - buyDayPrice;
            }
        }

        return maxP;
    }
}
