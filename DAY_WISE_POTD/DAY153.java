//Module 17 - Graph
//Problem 16 - Day153 - Floyd Warshall


class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;
        
        for(int k = 0; k < V; k++) {
            
            for(int i = 0; i < V; i++) {
                
                for(int j = 0; j < V; j++) {
                
                    if(dist[i][j] > (dist[i][k] + dist[k][j])) {
                    
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
                
            }
            
            
        }
        
    }
}
