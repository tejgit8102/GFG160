//Problem - Palindrome Linked List

/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {
        // Your code here
        if(head == null || head.next == null){
            return true;
        }
        
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node prev = null;
        while(slow != null){
            Node nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        
        Node left = head, right = prev;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        
        return true;
        
    }
}
