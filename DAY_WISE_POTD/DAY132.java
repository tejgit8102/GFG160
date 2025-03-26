//Module 15 - Dynamic Programming
//Problem 23 - Day132 - Word Break

class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for(int i = 1; i <= n; i++) {
            for(String w : dictionary) {
                int start = i - w.length();
                if(start >= 0 && dp[start] &&
                   s.substring(start, start + w.length()).equals(w)) {
                       dp[i] = true;
                       break;
                   }
            }
        }
        
        return dp[n];
        
    }
}
