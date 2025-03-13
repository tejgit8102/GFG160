//Module 15 - Dynamic Programming
//Problem 10 - Day119 - 0 - 1 Knapsack Problem

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        
        for(int i = 0; i <= n; i++) {
            for(int w = 0; w <= W; w++) {
                if(i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if(wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][W];
        
    }
}
