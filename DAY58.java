//Module 7 - Two Pointer Technique
//Problem 8 - Day58 - Longest substring with distinct characters

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        int maxLength = 0;
        
        int left = 0;
        int right = 0;
        
        int[] lastIndex = new int[256];
        
        for(int i = 0; i < 256; i++){
            lastIndex[i] = -1;
        }
        
        while(right < n){
            char currentChar = s.charAt(right);
            
            if(lastIndex[currentChar] >= left){
                left = lastIndex[currentChar] + 1;
            }
            
            lastIndex[currentChar] = right;
            
            maxLength = Math.max(maxLength, right - left + 1);
            
            right++;
        }
        
        return maxLength;
    }
}
