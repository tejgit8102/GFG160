//Problem - Merge K sorted linked lists


/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        if(arr == null || arr.isEmpty()){
            return null;
        }
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
        
        for(Node head: arr){
            if(head != null){
                minHeap.add(head);
            }
        }
        
        Node dummy = new Node(0);
        Node current = dummy;
        
        while(!minHeap.isEmpty()){
            Node smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;
            
            if(smallestNode.next != null){
                minHeap.add(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}
