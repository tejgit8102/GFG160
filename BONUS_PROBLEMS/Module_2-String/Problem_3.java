//Problem  - Palindrome Sentence

class Solution {
    public boolean sentencePalindrome(String s) {
        // Step 1: Preprocess the string
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

        // Step 2: Check for palindrome using two pointers
        int left = 0, right = filtered.length() - 1;
        while (left < right) {
            if (filtered.charAt(left) != filtered.charAt(right)) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }

        return true; // Palindrome
    }
}
