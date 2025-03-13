//Module 15 - Dynamic Programming
//Problem 8 - Day117 - Ways to Reach the n'th Stair

class Solution {
    int countWays(int n) {
        // your code here
        if(n <= 1) return 1;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return (int) dp[n];
    }
}
