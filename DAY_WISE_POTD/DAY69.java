//Module 9 - Linked List
//Problem 5 - Day69 - Add Number Linked Lists

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/


class Solution{
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    static Node addTwoLists(Node num1, Node num2){
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node sum = null;
        int carry = 0;
        
        while(num1 != null || num2 != null || carry > 0){
            int newVal = carry;
            
            if(num1 != null) newVal += num1.data;
            if(num2 != null) newVal += num2.data;
            
            carry = newVal / 10;
            
            newVal = newVal % 10;
            
            Node newNode = new Node(newVal);
            
            newNode.next = sum;
            sum = newNode;
            
            if(num1 != null) num1 = num1.next;
            if(num2 != null) num2 = num2.next;
        }
        while(sum != null && sum.data == 0){
            Node temp = sum.next;
            sum.next = null;
            sum = temp;
        }
        if(sum == null) return new Node(0);
        return sum;
    }
}
