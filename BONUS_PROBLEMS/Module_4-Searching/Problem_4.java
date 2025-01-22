//Problem - Square Root

class Solution {
    int floorSqrt(int n) {
        // Handle edge cases
        if (n == 0 || n == 1) {
            return n;
        }

        // Binary search for the floor of the square root
        int low = 0, high = n;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If mid * mid equals n, then it's the exact square root
            if (mid * mid == n) {
                return mid;
            }
            // If mid * mid is less than n, then we need to look for a larger value
            else if (mid * mid < n) {
                result = mid;  // Update result to mid
                low = mid + 1;
            }
            // If mid * mid is greater than n, we need to look for a smaller value
            else {
                high = mid - 1;
            }
        }

        return result;
    }
}
