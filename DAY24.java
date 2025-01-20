//Module 3 - Sorting
//Problem 4 - Day24 - Overlapping Intervals

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // List to store the merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();

        // Edge case: if the array is empty or has only one interval
        if (arr == null || arr.length == 0) {
            return mergedIntervals;
        }

        // Sort the intervals by their start times
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize the first interval
        int[] currentInterval = arr[0];
        mergedIntervals.add(currentInterval);

        // Iterate through the intervals
        for (int[] interval : arr) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // Check if the current interval overlaps with the next one
            if (currentEnd >= nextStart) {
                // Merge the intervals by updating the end time
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the next interval to the list
                currentInterval = interval;
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals;
    }
}
