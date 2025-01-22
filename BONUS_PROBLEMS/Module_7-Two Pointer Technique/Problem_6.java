//Problem - Minimum Removals for Target Sum

class Solution {
    public int minRemovals(int[] arr, int k) {
        // code here
        
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }
        
        if(k > totalSum) return -1;
        
        int target = totalSum - k;
        int currentSum = 0, maxLength = -1;
        int left = 0;
        
        for(int right = 0; right < arr.length; right++){
            currentSum += arr[right];
            
            while(currentSum > target){
                currentSum -= arr[left];
                left++;
            }
            
            if(currentSum == target){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            
        }
        
        if(maxLength == -1) return -1;
        
        return arr.length - maxLength;
        
    }
}
