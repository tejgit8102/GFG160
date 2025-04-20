//Module 19 - Bit Manipulation
//Problem 1 - Day157 - Find Only Repetitive Element from 1 to n-1

class Solution {
    public int findDuplicate(int[] arr) {
        // code here
        int n = arr.length;
        int res = 0;
        
        for(int i = 0; i < n - 1; i++) {
            res = res ^ (i + 1) ^ arr[i];
        }
        
        res = res ^ arr[n - 1];
        
        return res;
        
    }
}
