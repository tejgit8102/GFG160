//Problem - Meeting Rooms II

class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        
        int n = start.length;
        int rooms = 0;
        int maxRooms = 0;
        int l = 0, r = 0;
        
        while(l < n && r < n) {
            if(start[l] < end[r]) {
                rooms++;
                l++;
            }
            else {
                rooms--;
                r++;
            }
            
            maxRooms = Math.max(maxRooms, rooms);
        }
        
        return maxRooms;
    }
}
