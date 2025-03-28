//Problem - Egg Dropping Puzzle

class Solution {

    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int eggDrop(int n, int k) {
        // code here
        
        int[][] dp = new int[k + 1][n + 1];
        
        int cnt = 0;
        
        while(dp[cnt][n] < k) {
            cnt++;
            
            for(int i = 1; i <= n; i++) {
                dp[cnt][i] = 1 + dp[cnt - 1][i - 1] + dp[cnt - 1][i];
            }
        }
        
        return cnt;
        
    }
}
