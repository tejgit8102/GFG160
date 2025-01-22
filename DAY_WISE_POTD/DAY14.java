//Module 2 - Strings
//Problem 1 - Day14 - Implement Atoi

class Solution {
    public int myAtoi(String s) {
        // Edge case: empty string
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0, n = s.length();
        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If the string becomes empty after trimming spaces
        if (i >= n) {
            return 0;
        }

        // Step 2: Check for a sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to integer
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Handle overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        // Return the result with its sign
        return result * sign;
    }
}
