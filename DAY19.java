//Module 2 - Strings
//Problem 6 - Day19 - Min Chars to Add for Palindrome

class Solution {
    public static int minChar(String s) {
        // Reverse the string
        String reversed = new StringBuilder(s).reverse().toString();
        // Create the concatenated string
        String combined = s + "#" + reversed;
        // Compute the LPS array
        int[] lps = computeLPS(combined);
        // Length of the longest palindromic suffix
        int longestPalindromicSuffix = lps[lps.length - 1];
        // Minimum characters to add
        return s.length() - longestPalindromicSuffix;
    }

    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;
        
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
