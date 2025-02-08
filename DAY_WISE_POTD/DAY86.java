//Module 11 - Tree
//Problem 7 - Day86 - Tree Boundary Traversal

// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(node == null) return result;
        
        if(!isLeaf(node)) result.add(node.data);
        
        addLeftBoundary(node.left, result);
        
        addLeaves(node, result);
        
        addRightBoundary(node.right, result);
        
        return result;
    }
    
    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    
    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        Node curr = node;
        while(curr != null){
            if(!isLeaf(curr)) result.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    private void addLeaves(Node node, ArrayList<Integer> result) {
        if(node == null) return;
        if(isLeaf(node)) {
            result.add(node.data);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }
    
    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = node;
        while(curr != null){
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        
        for(int i = temp.size() - 1; i>=0; i--){
            result.add(temp.get(i));
        }
    }
}

