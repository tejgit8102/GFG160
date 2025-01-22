//Module 1 - Arrays
//Problem 7 - Stock Buy and Sell – Multiple Transaction Allowed


class Solution {
    public int maximumProfit(int prices[]) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // If the current price is greater than the previous price, calculate the profit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}
