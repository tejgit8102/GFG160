//Module 8 - Prefix Sum
//Problem 1 - Day61 - Equilibrium Point

class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }
        
        int leftSum = 0;
        
        for(int i = 0; i < arr.length; i++){
            int rightSum = totalSum - leftSum - arr[i];
            
            if(leftSum == rightSum){
                return i;
            }
            
            leftSum += arr[i];
        }
        
        return -1;
    }
}
