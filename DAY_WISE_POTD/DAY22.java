//Module 3 - Sorting
//Problem 2 - Day22 - Find H-Index

class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // Sort the citations array
        Arrays.sort(citations);
        int n = citations.length;

        // Iterate to find the maximum H-index
        for (int i = 0; i < n; i++) {
            int h = n - i; // Papers with at least h citations
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0; // If no valid H-index is found
    }
}
