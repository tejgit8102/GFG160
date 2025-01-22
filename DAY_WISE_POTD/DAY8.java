//Module 1 - Arrays
//Problem 8 - Stock Buy and Sell – Max one Transaction Allowed


class Solution {
    public int maximumProfit(int prices[]) {
        // Edge case: If there are no prices or only one day, profit is 0
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize variables
        int minPrice = prices[0]; // Minimum price seen so far
        int maxProfit = 0;        // Maximum profit

        // Traverse the array
        for (int i = 1; i < prices.length; i++) {
            // Update minimum price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit and update maxProfit
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
