//Module 4 - Searching
//Problem 5 - Day32 - K-th element of two Arrays

class Solution {
    public int kthElement(int a[], int b[], int k) {
        if (a.length > b.length) {
            return kthElement(b, a, k); // Ensure the first array is smaller.
        }

        int n = a.length, m = b.length;
        int low = Math.max(0, k - m), high = Math.min(k, n);

        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = k - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];
            int minRightA = (partitionA == n) ? Integer.MAX_VALUE : a[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
            int minRightB = (partitionB == m) ? Integer.MAX_VALUE : b[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                return Math.max(maxLeftA, maxLeftB); // Found the k-th element.
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1; // Move left in array a.
            } else {
                low = partitionA + 1; // Move right in array a.
            }
        }
        
        throw new IllegalArgumentException("Invalid input");
    }
}
