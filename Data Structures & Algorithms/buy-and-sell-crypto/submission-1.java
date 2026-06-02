class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuyPrice = prices[0];
        //+++
        //+++++
        //++++++++
        //++++++++++++
        //+++++
        //++
        //+++++++
        //++++++++++
        for (int sell : prices) {
            //update possible profit and update max profit
            int currentProfit = sell - minBuyPrice;
            // max profit
            maxProfit = Math.max(maxProfit, currentProfit);
            // check if this is good buy time
            minBuyPrice = Math.min(minBuyPrice, sell);
        }
        return maxProfit;
    }
}
