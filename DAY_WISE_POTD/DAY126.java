//Module 15 - Dynamic Programming
//Problem 17 - Day126 - Stock Buy and Sell – Max 2 Transactions Allowed

class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int n = prices.length;
        if(n == 0) return 0;
        
        int[][] curr = new int[3][2];
        int[][] next = new int[3][2];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int k = 1; k <= 2; k++) {
                curr[k][1] = Math.max(-prices[i] + next[k][0], next[k][1]);
                curr[k][0] = Math.max(prices[i] + next[k - 1][1], next[k][0]);
            }
            
            next = curr.clone();
        }
        
        return curr[2][1];
        
    }
}
