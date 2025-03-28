//Problem - MaxSkill

class Solution {
    public static int maxSkill(int[] arr) {
        // code here
        int n = arr.length;
        
        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[n + 1] = 1;
        for(int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }
        
        int[][]dp = new int[n + 2][n + 2];
        
        for(int length = 1; length <= n; length++) {
            for(int left = 1; left <= n - length + 1; left++) {
                int right = left + length - 1;
                
                for(int k = left; k <= right; k++) {
                    
                    int skill = nums[left - 1] * nums[k] * nums[right + 1];
                    
                    int totalSkill = skill + dp[left][k - 1] + dp[k + 1][right];
                    
                    dp[left][right] = Math.max(dp[left][right], totalSkill);
                }
            }
        }
        
        return dp[1][n];
    }
}
