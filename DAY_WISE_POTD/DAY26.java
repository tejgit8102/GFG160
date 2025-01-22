//Module 3 - Sorting
//Problem 6 - Day26 - Non-overlapping Intervals

class Solution {
    static int minRemoval(int intervals[][]) {
        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // Count of intervals to remove
        int prevEnd = Integer.MIN_VALUE; // End time of the last non-overlapping interval

        for (int[] interval : intervals) {
            if (interval[0] < prevEnd) {
                // Overlap detected, increment removal count
                count++;
            } else {
                // Update the end time of the last added interval
                prevEnd = interval[1];
            }
        }

        return count;
    }
}
