//Module 15 - Dynamic Programming
//Problem 11 - Day120 - Coin Change (Count Ways)

class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];
        
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                
                if(j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        
        return dp[n][sum];
    }
}
