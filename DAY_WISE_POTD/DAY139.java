//Module 17 - Graph
//Problem 2 - Day139 - BFS of Graph

// User function Template for Java
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        int s = 0;
        
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        visited[s] = true;
        q.add(s);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            
            
            for(int x : adj.get(curr)) {
                if(!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
    }
}
