//Problem - Symmetric Tree

/*
class of the node of the tree is as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    
    
    static boolean isSymmetric(Node root) {
        // your code here;
        if(root == null){
            return  true;
        }
        
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        s1.push(root.left);
        s2.push(root.right);
        
        while(!s1.isEmpty() && !s2.isEmpty()) {
            Node node1 = s1.pop();
            Node node2 = s2.pop();
            
            if(node1 == null && node2 == null) {
                continue;
            }
            
            if(node1 == null || node2 == null || node1.data != node2.data) {
                return false;
            }
            
            s1.push(node1.left);
            s2.push(node2.right);
            
            s1.push(node1.right);
            s2.push(node2.left);
        }
        
        return s1.isEmpty() && s2.isEmpty();
    }
}
