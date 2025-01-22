//Problem - Min Subsets with Consecutive Numbers

class Solution {
    public int numOfSubset(int[] arr) {
        // Your code goes here
        
        Arrays.sort(arr);
        
        int subsets = 1;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i - 1] + 1){
                subsets++;
            }
        }
        
        return subsets;
    }
}
