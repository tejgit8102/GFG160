//Problem - Last Moment Before All Ants Fall Out of a Plank
class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxLeft = 0, maxRight = 0;

        // Calculate the maximum time for ants moving left
        for (int pos : left) {
            maxLeft = Math.max(maxLeft, pos);
        }

        // Calculate the maximum time for ants moving right
        for (int pos : right) {
            maxRight = Math.max(maxRight, n - pos);
        }

        // Return the maximum of both times
        return Math.max(maxLeft, maxRight);
    }
}
