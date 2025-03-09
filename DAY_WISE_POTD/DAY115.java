//Module 15 - Dynamic Programming
//Problem 6 - Day115 - Palindrome SubStrings

class Solution {
    public int countPS(String s) {
        // code here
        int n = s.length();
        int count = 0;
        
        for(int center = 0; center < n; center++) {
            count += countPalindromes(s, center, center);
            count += countPalindromes(s, center, center + 1);
        }
        
        return count;
        
    }
    
    private int countPalindromes(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if(right - left + 1 >= 2) {
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
}
