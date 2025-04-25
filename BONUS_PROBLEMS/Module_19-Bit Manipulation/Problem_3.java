//Problem - Sum of XOR of all possible subsets

class Solution {
    int subsetXORSum(int arr[]) {
        // code here
        int result = 0;
        for(int num : arr) {
            result |= num;
        }
        
        return result << (arr.length - 1);
        
    }
}
