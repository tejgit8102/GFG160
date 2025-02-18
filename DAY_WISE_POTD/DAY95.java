//Module 12 - Heap
//Problem 1 - Day95 - k largest elements

class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        for(int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        
    for(int i = k; i < n; i++) {
        if(arr[i] > pq.peek()) {
            pq.poll();
            pq.add(arr[i]);
        }
    }
    
    ArrayList<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
        result.add(pq.poll());
    }
    
    result.sort(Collections.reverseOrder());
    return result;
    }
}
