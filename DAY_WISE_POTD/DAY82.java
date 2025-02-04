//Module 11 - Tree
//Problem 3 - Day82 - Diameter of a Binary Tree

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
    int maxDiameter = 0;
    
    int diameter(Node root) {
        // Your code here
        height(root);
        return maxDiameter;
    }
    
    int height(Node node) {
        if(node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
