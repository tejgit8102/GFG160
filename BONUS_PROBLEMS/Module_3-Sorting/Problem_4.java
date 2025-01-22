//Problem - Make array elements unique


class Solution {
    public int minIncrements(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        int increments = 0;

        // Step 2: Traverse the array and adjust duplicates
        for (int i = 1; i < arr.length; i++) {
            // If the current element is less than or equal to the previous one
            if (arr[i] <= arr[i - 1]) {
                // Increment it to one more than the previous element
                int incrementNeeded = arr[i - 1] + 1 - arr[i];
                arr[i] += incrementNeeded;
                increments += incrementNeeded;
            }
        }

        // Step 3: Return the total number of increments
        return increments;
    }
}
