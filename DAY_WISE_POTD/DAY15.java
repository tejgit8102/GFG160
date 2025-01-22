//Module 2 - Strings
//Problem 2 - Day15 - Add Binary Strings


class Solution {
    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;

        // If one string is empty, return the other string
        if (i == -1) return s2;
        if (j == -1) return s1;

        StringBuilder res = new StringBuilder();
        char ch1, ch2, carry = '0';
        int temp;

        while (i >= 0 || j >= 0) {
            // If characters exist in s1 and s2, assign them to ch1 and ch2
            // Otherwise, assign '0'
            if (i >= 0)
                ch1 = s1.charAt(i);
            else
                ch1 = '0';

            if (j >= 0)
                ch2 = s2.charAt(j);
            else
                ch2 = '0';

            temp = (ch1 - '0') + (ch2 - '0') + (carry - '0');

            // Calculate the sum of ch1, ch2, and carry
            // and assign the corresponding value to res and carry
            if (temp == 0) {
                res.append('0');
                carry = '0';
            } else if (temp == 1) {
                res.append('1');
                carry = '0';
            } else if (temp == 2) {
                res.append('0');
                carry = '1';
            } else {
                res.append('1');
                carry = '1';
            }

            i--;
            j--;
        }

        // If carry is still '1' after all the calculations, append it to the result
        if (carry == '1') res.append(carry);

        // Remove any leading zeros in the result
        int len = res.length();
        while (len > 0 && res.charAt(len - 1) == '0') len--;

        // If result is empty after removing leading zeros, return "0"
        if (len == 0) return "0";

        // Reverse the result to get the correct value
        // and return the result
        res.setLength(len);
        return res.reverse().toString();
    }
}
