//Module 4 - Searching
//Problem 6 - Day33 - Aggressive Cows

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Step 1: Sort the stall positions
        Arrays.sort(stalls);
        
        // Step 2: Binary search on the answer
        int left = 0;
        int right = stalls[stalls.length - 1] - stalls[0]; // maximum possible distance
        
        int bestDistance = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Mid distance
            if (canPlaceCows(stalls, k, mid)) {
                bestDistance = mid; // If placing cows is possible, update the answer
                left = mid + 1; // Try for a larger distance
            } else {
                right = mid - 1; // Try for a smaller distance
            }
        }
        
        return bestDistance;
    }
    
    // Function to check if it's possible to place k cows with at least 'dist' distance between them
    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1; // Place the first cow at the first stall
        int lastPosition = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= dist) {
                count++; // Place a cow at this stall
                lastPosition = stalls[i]; // Update the position of the last placed cow
            }
            if (count == k) {
                return true; // All cows are placed
            }
        }
        
        return false; // If it's not possible to place all cows
    }
}
