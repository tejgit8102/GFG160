//Module 16 - Greedy
//Problem 2 - Day134 - Activity Selection

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n = start.length;
        int ans = 0;
        
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = finish[i];
            arr[i][1] = start[i];
        }
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        int finishtime = -1;
        
        for(int i = 0; i < n; i++) {
            if(arr[i][1] > finishtime) {
                finishtime = arr[i][0];
                ans++;
            }
        }
        return ans;
    }
}
