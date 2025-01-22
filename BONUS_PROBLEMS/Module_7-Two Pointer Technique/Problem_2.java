//Problem - 3 Sum Closest

class Solution {
    static int closest3Sum(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        
        int n = arr.length;
        int closestSum = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;
            
            while(left < right){
                int currentSum = arr[i] + arr[left] + arr[right];
                int diff = Math.abs(currentSum - target);
                
                if(diff < minDiff || (diff == minDiff && currentSum > closestSum)) {
                    closestSum = currentSum;
                    minDiff = diff;
                }
                
                if(currentSum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closestSum;
    }
};
