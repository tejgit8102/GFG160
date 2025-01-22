//Problem - Split array in three equal sum subarrays

class Solution {

    public List<Integer> findSplit(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // If totalSum is not divisible by 3, return {-1, -1}
        if (totalSum % 3 != 0) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        int targetSum = totalSum / 3;
        int currentSum = 0;
        int count = 0;

        // Initialize indices i and j
        int i = -1, j = -1;

        // Iterate through the array to find the split indices
        for (int k = 0; k < arr.length; k++) {
            currentSum += arr[k];

            if (currentSum == targetSum) {
                count++;
                currentSum = 0; // Reset currentSum for the next segment

                if (count == 1) {
                    i = k; // First split point
                } else if (count == 2) {
                    j = k; // Second split point
                    break;
                }
            }
        }

        // Check if we successfully found both split points
        if (count == 2 && j < arr.length - 1) {
            result.add(i);
            result.add(j);
        } else {
            result.add(-1);
            result.add(-1);
        }

        return result;
    }
}
