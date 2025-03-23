//Module 15 - Dynamic Programming
//Problem 20 - Day129 - Total Decoding Messages


class Solution {
    public int countWays(String digits) {
        // code here
        int n = digits.length();
        
        if(n == 0 || digits.charAt(0) == '0') {
            return 0;
        }
        
        int prev1 = 1, prev2 = 0;
        
        for(int i = 1; i <= n; ++i) {
            int current = 0;
            
            if(digits.charAt(i - 1) != '0') {
                current += prev1;
            }
            
            if(i > 1) {
                int twoDigit = 
                    (digits.charAt(i - 2) - '0') * 10 + (digits.charAt(i - 1) - '0');
                if(twoDigit >= 10 && twoDigit <= 26) {
                    current += prev2;
                }
            }
            
            
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
        
    }
}
