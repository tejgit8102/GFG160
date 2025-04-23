//Module 19 - Bit Manipulation
//Problem 4 - Day160 - Unique Number II

class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        int xorVal = 0;
        for(int i : arr) {
            xorVal ^= i;
        }
        
        xorVal &= -xorVal;
        
        int[] res = new int[2];
        
        for(int num : arr) {
            if((num & xorVal) == 0) {
                res[0] ^= num;
            }
            
            else{
                res[1] ^= num;
            }
        }
        
        if(res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        
        return res;
        
    }
}
