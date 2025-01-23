//Module 9 - Linked List
//Problem 6 - Day70 - Clone List with Next and Random

/*linked list node
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        if(head == null){
            return null;
        }
        
        Node current = head;
        while(current != null){
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        
        current = head;
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        Node original = head;
        Node copy = head.next;
        Node copyHead = copy;
        
        while(original != null){
            original.next = original.next.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }
        
        return copyHead;
    }
}
