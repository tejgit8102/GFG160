//Problem - Palindromic Partitioning


class Solution {
    
    static void generatePal(String s, boolean[][] isPalin) {
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            isPalin[i][i] = true;
        }
        
        for(int len = 2; len <= n; len++) {
            for(int i = 0, j = i + len - 1; j < n; i++, j++) {
                
                if(s.charAt(i) == s.charAt(j) && (len == 2 || isPalin[i + 1][j - 1])) {
                    
                    isPalin[i][j] = true;
                }
            }
        }
    }
    
    
    static int palPartition(String s) {
        // code here
        int n = s.length();
        
        boolean[][] isPalin = new boolean[n][n];
        
        generatePal(s, isPalin);
        
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        
        
        dp[0] = 0;
        
        for(int i = 1; i < n; i++) {
            
            if(isPalin[0][i]) {
                
                dp[i] = 0;
            } else {
                for (int j = i; j >= 1; j--) {
                    if(isPalin[j][i]) {
                        dp[i] = Math.min(dp[i], 1 + dp[j - 1]);
                    }
                }
            }
        }
        
        return dp[n - 1];
        
    }
};
