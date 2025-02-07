//Module 11 - Tree
//Problem 6 - Day85 - Inorder Traversal

/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }
    
    void inOrderTraversal(Node node, ArrayList<Integer> result){
        if(node == null) return;
        
        inOrderTraversal(node.left, result);
        
        result.add(node.data);
        
        inOrderTraversal(node.right, result);
    }
}
