//Module 11 - Tree
//Problem 13 - Day92 - Pair Sum in BST


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
    
    static void correctBSTUtil(Node root, Node[] first, Node[] middle, Node[] last, Node[] prev) {
        if(root == null) return;
        
        correctBSTUtil(root.left, first, middle, last, prev);
        
        if(prev[0] != null && root.data < prev[0].data) {
            
            if(first[0] == null){
                first[0] = prev[0];
                middle[0] = root;
            }
            else
                last[0] = root;
        }
        
        prev[0] = root;
        
         correctBSTUtil(root.right, first, middle, last, prev);
    }
    
    static void correctBST(Node root) {
        // code here.
        Node[] first = {null}, middle = {null}, last = {null}, prev = {null};
        
        correctBSTUtil(root, first, middle, last, prev);
        
        if(first[0] != null && last[0] != null)
            swap(first[0], last[0]);
        else if(first[0] != null && middle[0] != null)
            swap(first[0], middle[0]);
        
    }
    
    static void swap(Node a, Node b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
}
