//Problem - Intersection in Y Shaped Lists

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    static Node intersectPoint(Node head1, Node head2) {
        // code here
        int len1 = getSize(head1);
        int len2 = getSize(head2);
        
        while(len1 > len2){
            head1 = head1.next;
            len1--;
        }
        while(len2 > len1){
            head1 = head2.next;
            len2--;
        }
        while(head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return head1;
        
    }
    
    static int getSize(Node head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
}
