//Problem - Course Schedule

class Solution {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[n];
        
        for(int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            adj.get(src).add(dest);
            inDegree[dest]++;
        }
        
        
        Queue<Integer> q = new  LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        ArrayList<Integer> order = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int current = q.poll();
            order.add(current);
            
            for(int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        if(order.size() == n) {
            return order;
        }
        
        return new ArrayList<>();
    }
}
