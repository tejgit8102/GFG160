//Module 17 - Graph
//Problem 11 - Day148 - Dijkstra Algorithm

class Solution {
    public List<int[]>[] constructAdj(int[][] edges, int V) {
        
        List<int[]>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj[u].add(new int[] {v, wt});
            adj[v].add(new int[] {u, wt});
        }
        
        return adj;
    }
    
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        List<int[]>[] adj = constructAdj(edges, V);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        pq.offer(new int[] {0, src});
        dist[src] = 0;
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[1];
            
            for(int[] x : adj[u]) {
                int v = x[0];
                int weight = x[1];
                
                if(dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[] {dist[v], v});
                }
            }
        }
        
        return dist;
    }
}
