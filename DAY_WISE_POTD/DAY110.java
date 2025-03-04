//Module 15 - Dynamic Programming
//Problem 1 - Day110 - Longest Increasing Subsequence

class Solution {
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        if (n == 0) return 0;
        
        int dp[] = new int[n];
        int maxLen = 1;
        
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}
