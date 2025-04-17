//Problem - Bipartite Graph

class Solution {
    static ArrayList<ArrayList<Integer>> constructadj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
    
    
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        ArrayList<ArrayList<Integer>> adj = constructadj(V, edges);
        
        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                color[i] = 0;
                q.offer(i);
                
                while(!q.isEmpty()) {
                    int u = q.poll();
                    
                    for(int v : adj.get(u)) {
                        if(color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
