//Problem - Minimum Cost of ropes


class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : arr) {
            pq.add(num);
        }
        
        int res = 0;
        
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            
            res += first + second;
            
            pq.add(first + second);
        }
        
        return res;
        
    }
}
