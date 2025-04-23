//Module 19 - Bit Manipulation
//Problem 3 - Day159 - Unique Number I


class Solution {
    public int findUnique(int[] arr) {
        // code here
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }
}
