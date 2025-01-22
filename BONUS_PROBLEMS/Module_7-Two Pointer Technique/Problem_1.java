//Problem - Triplet Sum in Array

class Solution {
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean hasTripletSum(int arr[], int target) {
        // Your code Here
        
        Arrays.sort(arr);
        
        int n = arr.length;
        
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;
            
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                
                if(sum == target){
                    return true;
                }
                
                else if(sum < target){
                    left++;
                }
                
                else{
                    right--;
                }
            }
        }
        
        return false;
        
    }
}
