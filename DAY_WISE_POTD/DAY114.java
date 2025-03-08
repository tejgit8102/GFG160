//Module 15 - Dynamic Programming
//Problem 5 - Day114 - Longest Palindrome in a String

class Solution {
    static String longestPalindrome(String s) {
        // code here
        int count = -1;
        String ans = "";
        
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];
        
        for(int g = 0; g < n; g++) {
            for(int i = 0, j = g; j < n; i++, j++) {
                if(g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                
                if(dp[i][j]  && count < s.substring(i, j + 1).length()) {
                    ans = s.substring(i, j + 1);
                    count = ans.length();
                }
            }
        }
        
        return ans;
        
    }
}

