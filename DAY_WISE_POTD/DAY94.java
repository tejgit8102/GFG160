//Module 11 - Tree
//Problem 15 - Day94 - Serialize and deserialize a binary tree

/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Node node  = queue.poll();
            if(node != null) {
                result.add(node.data);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }
        return result;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        if(arr == null|| arr.isEmpty()) return null;
        
        Node root = new Node(arr.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        
        while(!queue.isEmpty() && i < arr.size()) {
            Node node = queue.poll();
            
            if(arr.get(i) != null) {
                node.left = new Node(arr.get(i));
                queue.add(node.left);
            }
            i++;
            
            if(i < arr.size() && arr.get(i) != null) {
                node.right = new Node(arr.get(i));
                queue.add(node.right);
            }
            i++;
        }
        
        return root;
    }
    
    public void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
}
