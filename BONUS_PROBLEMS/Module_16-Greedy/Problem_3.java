//Problem - Largest number in one swap

class Solution {
    String largestSwap(String s) {
        // code here
        char[] arr = s.toCharArray();
        char maxDigit = '0';
        int maxIndex = -1;
        int l = -1, r = -1;
        
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > maxDigit) {
                maxDigit = arr[i];
                maxIndex = i;
                continue;
            }
            
            if(arr[i] < maxDigit) {
                l = i;
                r = maxIndex;
            }
        }
        
        if(l == -1) {
            return s;
        }
        
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        
        return new String(arr);
        
    }
}
