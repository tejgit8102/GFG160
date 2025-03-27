//Problem - Ugly Number II

class Solution {
    public static int uglyNumber(int n) {
        // code here
        int[] arr = new int[n];
        
        int ind2 = 0, ind3 = 0, ind5 = 0;
        
        int mulTwo = 2, mulThree = 3, mulFive = 5;
        
        int nextNum = 1;
        
        arr[0] = 1;
        
        for(int i = 1; i < n; i++) {
            nextNum = Math.min(mulTwo, Math.min(mulThree, mulFive));
            arr[i] = nextNum;
            
            if(nextNum == mulTwo) {
                ind2++;
                mulTwo = arr[ind2] * 2;
            }
            if(nextNum == mulThree) {
                ind3++;
                mulThree = arr[ind3] * 3;
            }
            if(nextNum == mulFive) {
                ind5++;
                mulFive = arr[ind5] * 5;
            }
        }
        
        return nextNum;
        
    }
}
