//Module 9 - Linked List
//Problem 33 - Day67 - Merge two sorted linked lists

/*
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        
        Node dummy = new Node(0);
        Node tail = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        if(head1 != null){
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        
        return dummy.next;
    }
}
