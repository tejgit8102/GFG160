//Problem - Flattening a Linked List


class Solution {
    // Function to flatten a linked list
    Node mergeTwoLists(Node a, Node b){
        if(a == null) return b;
        if(b == null) return a;
        
        Node result;
        
        if(a.data < b.data){
            result = a;
            result.bottom = mergeTwoLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeTwoLists(a, b.bottom);
        }
        
        result.next = null;
        return result;
    }
    
    Node flatten(Node root) {
        // code here
        
        if(root == null || root.next == null){
            return root;
        }
        
        root.next = flatten(root.next);
        
        root = mergeTwoLists(root, root.next);
        
        return root;
    }
}
