//Module 19 - Bit Manipulation
//Problem 2 - Day158 - Missing in Array

class Solution {
    int missingNum(int arr[]) {
        // code here
        int xor1 = 0, xor2 = 0;
        int n = arr.length + 1;
        
        for(int i = 0; i < n - 1; i++) {
            xor2 ^= arr[i];
        }
        
        for(int i = 1; i <= n; i++) {
            xor1 ^= i;
        }
        
        return xor1 ^ xor2;
        
    }
}
