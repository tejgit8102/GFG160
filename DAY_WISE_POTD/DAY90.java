//Module 11 - Tree
//Problem 11 - Day90 - Check for BST

// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    int count = 0;
    int result = -1;
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        inOrderTraversal(root, k);
        return result;
    }
    
    private void inOrderTraversal(Node node, int k){
        if(node == null) return;
        
        inOrderTraversal(node.left, k);
        
        count++;
        if(count == k){
            result = node.data;
            return;
        }
        
        inOrderTraversal(node.right, k);
    }
}
