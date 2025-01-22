//Problem - Repetitive Addition Of Digits

class Solution {
    public int singleDigit(int n) {
        // Repeat the process until n becomes a single-digit number.
        while (n >= 10) {
            int sum = 0;

            // Add all digits of n.
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }

            // Update n to be the sum of its digits.
            n = sum;
        }

        return n;
    }
}
