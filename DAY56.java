//Module 7 - Two Pointer Technique
//Problem 6 - Day56 - Indexes of Subarray Sum

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0, sum = 0;
        
        for(int end = 0; end < arr.length; end++){
            sum += arr[end];
            
            while(sum > target && start <= end){
                sum -= arr[start];
                start++;
            }
            
            if(sum == target){
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }
        }
        
        result.add(-1);
        return result;
    }
}
