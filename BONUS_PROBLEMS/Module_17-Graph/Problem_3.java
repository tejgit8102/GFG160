//Problem - Connected Components in an Undirected Graph

class Solution {
    
    public int findParent(ArrayList<Integer> parent, int x) {
        if(parent.get(x) == x) return x;
        parent.set(x, findParent(parent, parent.get(x)));
        return parent.get(x);
    }
    
    
    public void unionSets(ArrayList<Integer> parent, int x, int y) {
        int px = findParent(parent, x);
        int py = findParent(parent, y);
        if(px != py) {
            parent.set(px, py);
        }
    }
    
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        
        ArrayList<Integer> parent = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            parent.add(i);
        }
        
        for(int[] edge : edges) {
            unionSets(parent, edge[0], edge[1]);
        }
        
        for(int i = 0; i < V; i++) {
            parent.set(i, findParent(parent, i));
        }
        
        Map<Integer, ArrayList<Integer>> resMap = new HashMap<>();
        for(int i = 0; i < V; i++) {
            resMap.putIfAbsent(parent.get(i), new ArrayList<>());
            resMap.get(parent.get(i)).add(i);
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : resMap.entrySet()) {
            res.add(entry.getValue());
        }
        
        return res;
        
    }
}
