//Module 3 - Sorting
//Problem 7 - Day27 - Merge Without Extra Space

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        // Start with the largest index in both arrays
        int i = n - 1, j = 0;

        // Compare elements at the boundary of both arrays
        while (i >= 0 && j < m) {
            if (a[i] > b[j]) {
                // Swap elements if a[i] is greater than b[j]
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
            }
            i--;
            j++;
        }

        // Sort both arrays to ensure final order
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
