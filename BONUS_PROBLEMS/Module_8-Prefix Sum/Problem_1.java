//Problem - Number of times graph cuts X-axis

class Solution {
    public int touchedXaxis(int[] arr) {
        // code here
        int curPos = 0, times = 0;
        for(int i = 0; i < arr.length; i++){
            if(curPos < 0 && curPos + arr[i] >= 0){
                times++;
            } else if (curPos > 0 && curPos + arr[i] <= 0){
                times++;
            }
            curPos += arr[i];
        }
        return times;
    }
}
