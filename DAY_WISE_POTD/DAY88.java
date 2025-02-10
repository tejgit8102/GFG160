//Module 11 - Tree
//Problem 9 - Day88 - K Sum Paths

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int count = 0;
    
    
    public int sumK(Node root, int k) {
        // code here
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, k, path);
        return count;
    }
    
    private void dfs(Node node, int k, ArrayList<Integer> path){
        if(node == null){
            return;
        }
        
        path.add(node.data);
        
        int sum = 0;
        for(int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if(sum == k) {
                count++;
            }
        }
        
        dfs(node.left, k, path);
        dfs(node.right, k, path);
        
        path.remove(path.size() - 1);
    }
}
