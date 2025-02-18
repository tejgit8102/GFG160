//Module 12 - Heap
//Problem 2 - Day96 - K Closest Points to Origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(getDistance(b), getDistance(a))
        );
        
        for(int[] point: points) {
            maxHeap.add(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
