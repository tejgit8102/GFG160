//Module 14 - Queue and Deque
//Problem 1 - Day108 - K Sized Subarray Maximum

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if(i >= k - 1) {
                result.add(arr[dq.peek()]);
            }
        }
        
        return result;
        
    }
}
