//Problem - Koko Eating Bananas

class Solution {
    public static int kokoEat(int[] arr, int k) {
        int low = 1, high = 0;

        // Find the maximum number of bananas in any pile (high value for binary search)
        for (int pile : arr) {
            high = Math.max(high, pile);
        }

        // Binary search for the minimum 's' that allows Koko to eat all bananas within k hours
        while (low < high) {
            int mid = (low + high) / 2;
            if (canFinish(arr, k, mid)) {
                high = mid;  // Try a smaller value for s
            } else {
                low = mid + 1;  // Increase s
            }
        }

        return low;
    }

    // Helper function to check if Koko can finish eating all bananas in k hours at 's' bananas per hour
    private static boolean canFinish(int[] arr, int k, int s) {
        int hours = 0;
        for (int pile : arr) {
            hours += (pile + s - 1) / s;  // This is equivalent to Math.ceil(pile / s)
        }
        return hours <= k;  // Return true if Koko can finish within k hours
    }
}
