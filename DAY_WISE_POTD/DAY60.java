//Module 7 - Two Pointer Technique
//Problem 10 - Day60 - Container With Most Water

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;
        
        while(left < right){
            
            int height = Math.min(arr[left], arr[right]);
            
            int width = right - left;
            
            maxArea = Math.max(maxArea, height * width);
            
            if(arr[left] < arr[right]){
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
        
    }
}
