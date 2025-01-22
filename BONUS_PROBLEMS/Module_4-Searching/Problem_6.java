//Problem - Minimum days to make M bouquets

class Solution {
    public static int minDaysBloom(int m, int k, int[] arr) {
        // If we don't have enough flowers to make m bouquets, return -1
        if (arr.length < m * k) {
            return -1;
        }

        // Binary search for the minimum day
        int low = 1, high = 0;

        // Determine the range of days: from the min to the max bloom day
        for (int day : arr) {
            high = Math.max(high, day);
        }

        while (low < high) {
            int mid = (low + high) / 2;
            if (canMakeBouquets(arr, mid, m, k)) {
                high = mid;  // Try to find a smaller day
            } else {
                low = mid + 1;  // We need to look at later days
            }
        }

        return low;
    }

    // Helper function to check if we can make m bouquets by the given day
    private static boolean canMakeBouquets(int[] arr, int day, int m, int k) {
        int count = 0;
        int flowers = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                flowers++;  // This flower can be used for a bouquet
                // If we have k flowers in a row, we can form a bouquet
                if (flowers == k) {
                    count++;
                    flowers = 0;  // Reset flowers for the next bouquet
                }
            } else {
                flowers = 0;  // Reset flower count if current flower has not bloomed by `day`
            }

            if (count >= m) {
                return true;  // We can form m bouquets
            }
        }
        return count >= m;  // Check if we can form m bouquets
    }
}
