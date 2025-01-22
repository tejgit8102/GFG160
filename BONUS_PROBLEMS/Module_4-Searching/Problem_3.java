//Problem - Median of 2 Sorted Arrays of Different Sizes

class Solution {
    public double medianOf2(int a[], int b[]) {
        // Ensure a[] is the smaller array
        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int n = a.length;
        int m = b.length;
        int left = 0, right = n;

        while (left <= right) {
            int i = left + (right - left) / 2;  // Partition index for a[]
            int j = (n + m + 1) / 2 - i;      // Partition index for b[]

            // Edge cases when i or j is at the boundary
            int aLeft = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int aRight = (i == n) ? Integer.MAX_VALUE : a[i];
            int bLeft = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int bRight = (j == m) ? Integer.MAX_VALUE : b[j];

            // Check if we have found the correct partition
            if (aLeft <= bRight && bLeft <= aRight) {
                // If the total length is odd, the median is the largest of the left half
                if ((n + m) % 2 == 1) {
                    return Math.max(aLeft, bLeft);
                } else {
                    // If the total length is even, the median is the average of the max of the left half and min of the right half
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
            } else if (aLeft > bRight) {
                // Move the partition in a[] to the left
                right = i - 1;
            } else {
                // Move the partition in a[] to the right
                left = i + 1;
            }
        }

        // If no solution is found (which theoretically shouldn't happen), return 0.
        return 0.0;
    }
}
