//Module 7 - Two Pointer Technique
//Problem 2 - Day52 - Count Pairs whose sum is less than target

class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        
        Arrays.sort(arr);
        
        int count = 0;
        int i = 0, j = arr.length - 1;
        
        while(i < j){
            if(arr[i] + arr[j] < target){
                count += (j - i);
                i++;
            } else {
                j--;
            }
        }
        
        return count;
        
    }
}
