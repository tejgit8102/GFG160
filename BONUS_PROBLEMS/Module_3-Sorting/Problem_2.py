#Problem - Meeting Rooms

class Solution:
    def canAttend(self, arr):
        # Sort the meetings by their starting time
        arr.sort(key=lambda x: x[0])
        
        # Check for overlaps
        for i in range(1, len(arr)):
            # If the current meeting starts before the previous one ends, return False
            if arr[i][0] < arr[i - 1][1]:
                return False
        
        # If no overlaps, return True
        return True
