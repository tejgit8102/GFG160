#Module 9 - Linked List
#Problem 2 - Day66 - Rotate a Linked List


'''

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

'''


class Solution:
    
    #Function to rotate a linked list.
    def rotate(self, head, k):
        # code here
        if not head or k == 0:
            return head
        
        curr = head
        length = 1
        
        while curr.next:
            curr = curr.next
            length += 1
            
        k %= length
        
        if k == 0:
            return head
        
        curr.next = head
        
        
        curr = head
        for _ in range(1, k):
            curr = curr.next
        
        newHead = curr.next
        
        curr.next = None
        return newHead


