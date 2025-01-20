//Module 4 - Searching
//Problem 4 - Day31 - Peak element

class Solution {

    public int peakElement(int[] arr) {
        int n = arr.length;

        // Handle edge cases with a single element
        if (n == 1) return 0;

        // Check the first and last elements as potential peaks
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        // Check for peaks in the rest of the array
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i; // Found a peak, return its index
            }
        }

        return -1; // This line should never be reached if input is valid
    }
}
