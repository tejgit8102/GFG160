//Module 15 - Dynamic Programming
//Problem 22 - Day131 - Boolean Parenthesization

class Solution {
    static boolean evaluate(int b1, int b2, char op) {
        if(op == '&') return (b1 & b2) == 1;
        if(op == '|') return (b1 | b2) == 1;
        return (b1 ^ b2) == 1;
    }
    
    static int countWays(String s) {
        // code here
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        
        for(int i = 0; i < n; i += 2 ) {
            dp[i][i][1] = (s.charAt(i) == 'T') ? 1 : 0;
            dp[i][i][0] = (s.charAt(i) == 'F') ? 1 : 0;
        }
        
        
        for(int len = 2; len < n; len += 2) {
            for(int i = 0; i < n - len; i += 2) {
                int j = i + len;
                dp[i][j][0] = dp[i][j][1] = 0;;
                
                for(int k = i + 1; k < j; k += 2) {
                    char op = s.charAt(k);
                    int leftTrue = dp[i][k - 1][1], leftFalse = dp[i][k -1][0];
                    int rightTrue = dp[k + 1][j][1], rightFalse = dp[k + 1][j][0];
                    
                    if(evaluate(1, 1, op)) dp[i][j][1] += leftTrue * rightTrue;
                    if(evaluate(1, 0, op)) dp[i][j][1] += leftTrue * rightFalse;
                    if(evaluate(0, 1, op)) dp[i][j][1] += leftFalse * rightTrue;
                    if(evaluate(0, 0, op)) dp[i][j][1] += leftFalse * rightFalse;
                    
                    if(!evaluate(1, 1, op)) dp[i][j][0] += leftTrue * rightTrue;
                    if(!evaluate(1, 0, op)) dp[i][j][0] += leftTrue * rightFalse;
                    if(!evaluate(0, 1, op)) dp[i][j][0] += leftFalse * rightTrue;
                    if(!evaluate(0, 0, op)) dp[i][j][0] += leftFalse * rightFalse;
                }
            }
        }
        
        return dp[0][n - 1][1];
    }
}
