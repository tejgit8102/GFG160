//Module 15 - Dynamic Programming
//Problem 16 - Day125 -Stock Buy and Sell – Max K Transactions Allowed

class Solution {
    static int maxProfit(int prices[], int k) {
        // code here
        int n = prices.length;
        if(n == 0 || k == 0) return 0;
        
        int[][] curr = new int[k + 1][2];
        int[][] next = new int[k + 1][2];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int l = 1; l <= k; l++) {
                curr[l][1] = Math.max(-prices[i] + next[l][0], next[l][1]);
                curr[l][0] = Math.max(prices[i] + next[l - 1][1], next[l][0]);
            }
            
            for(int l = 0; l <= k; l++){
                next[l][0] = curr[l][0];
                next[l][1] = curr[l][1];
            }
        }
        
        return curr[k][1];
        
    }
}
