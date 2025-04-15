//Module 17 - Graph
//Problem 14 - Day151 - Alien Dictionary

class Solution {
    private boolean cycleExist = false;
    private StringBuilder ans = new StringBuilder();
    private int[] exist = new int[26], vis = new int[26], rec = new int[26];
    private int[][] graph = new int[26][26];
    
    private void dfs(int u) {
        vis[u] = 1;
        rec[u] = 1;
        
        for(int v = 0; v < 26; v++) {
            if(graph[u][v] == 1 && vis[v] == 0) {
                dfs(v);
            } else if (graph[u][v] == 1 && rec[v] == 1) {
                cycleExist = true;
            }
        }
        
        ans.append((char)('a' + u));
        rec[u] = 0;
    }
    
    
    public String findOrder(String[] words) {
        // code here
        cycleExist = false;
        ans.setLength(0);
        ans.setLength(0);
        Arrays.fill(exist, 0);
        Arrays.fill(vis, 0);
        Arrays.fill(rec, 0);
        graph = new int[26][26];
        
        
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                exist[ch - 'a'] = 1;
            }
        }
        
        
        for (int i = 0; i + 1 < words.length; i++) {
            String a = words[i], b = words[i + 1];
            int n = a.length(), m = b.length(), ind = 0;
            
            while(ind < n && ind < m && a.charAt(ind) == b.charAt(ind)) {
                ind++;
            }
            
            if(ind != n && ind == m) {
                return "";
            }
            
            if(ind < n && ind < m) {
                graph[a.charAt(ind) - 'a'][b.charAt(ind) - 'a'] = 1;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            if(exist[i] == 1 && vis[i] == 0) {
                dfs(i);
            }
        }
        
        if(cycleExist) {
            return "";
        }
        
        return ans.reverse().toString();
    }
}
