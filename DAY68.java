//Module 9 - Linked List
//Problem 4 - Day68 - Linked List Group Reverse

/*node class of the linked list
class Node
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

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(head == null){
            return head;
        }
        
        Node curr = head;
        Node newHead = null;
        Node tail = null;
        
        while(curr != null){
            Node groupHead = curr;
            Node prev = null;
            Node nextNode = null;
            int count = 0;
            
            while(curr != null && count < k){
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }
            
            if(newHead == null){
                newHead = prev;
            }
            
            if(tail != null){
                tail.next = prev;
            }
            
            tail = groupHead;
        }
        
        return newHead;
    }
}
