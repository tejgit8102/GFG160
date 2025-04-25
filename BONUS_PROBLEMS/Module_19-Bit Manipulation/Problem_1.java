//Problem - Total Hamming Distance

class Solution {
    int totHammingDist(int arr[]) {
        // code here
        int n = arr.length;
        int count = 0;
        int[] countOne = new int[32];
        
        for(int num : arr) {
            for(int j = 0; j < 32; j++) {
                if ((num & (1 << j)) != 0) {
                    countOne[j]++;
                }
            }
        }
        
        for(int j = 0; j < 32; j++) {
            count += countOne[j] * (n - countOne[j]);
        }
        return count;
    }
}
