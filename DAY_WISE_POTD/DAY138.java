//Module 17 - Graph
//Problem 1 - Day138 - DFS of Graph

class Solution {
    
    private void dfsRec(int ch, boolean[] vis, ArrayList<Integer> ans, 
                                            ArrayList<ArrayList<Integer>> adj) {
                                                
        vis[ch] = true;
        ans.add(ch);
        
        for(int i = 0; i < adj.get(ch).size(); i++) {
            if(!vis[adj.get(ch).get(i)]) dfsRec(adj.get(ch).get(i), vis, ans, adj);
        }
    
                                                
    }
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int V = adj.size();
        
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        dfsRec(0, vis, ans, adj);
        
        return ans;
        
    }
}
