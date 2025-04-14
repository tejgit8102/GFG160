//Module 17 - Graph
//Problem 14 - Day151 - Clone an Undirected Graph

// User function Template for Java

/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution {
    // Map to hold original node to its copy
    static HashMap<Node, Node> copies = new HashMap<>();

    Node cloneGraph(Node node) {
        // If the node is NULL, return NULL
        if (node == null) return null;

        // If node is not yet cloned, clone it
        if (!copies.containsKey(node)) {
            Node clone = new Node(node.val);
            copies.put(node, clone);

            // Recursively clone neighbors
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }

        // Return the clone
        return copies.get(node);
    }
}
