//Module 11 - Tree
//Problem 14 - Day93 - Lowest Common Ancestor in a BST


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
    Node LCA(Node root, Node n1, Node n2) {
        // your code here.
        if(root == null){
            return null;
        }
        
        if(n1.data < root.data && n2.data < root.data) {
            return LCA(root.left, n1, n2);
        }
        
        if(n1.data > root.data && n2.data > root.data) {
            return LCA(root.right, n1, n2);
        }
        
        return root;
    }
}

