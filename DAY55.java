//Module 7 - Two Pointer Technique
//Problem 5 - Day55 - Count the number of possible triangles

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;
        
        for(int k = n - 1; k >= 2; k--){
            int i = 0;
            int j = k - 1;
            
            while(i < j){
                if(arr[i] + arr[j] > arr[k]){
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        
        return count;
    }
}
