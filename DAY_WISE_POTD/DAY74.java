//Module 9 - Linked List
//Problem 10 - Day74 - LRU Cache

class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    
    class Node{
        int key, value;
        Node prev, next;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail;
    
    
    public LRUCache(int cap) {
        // code here
        this.capacity = cap;
        this.map = new HashMap<>();
        
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        // your code here
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node node = map.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        // your code here
         if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
         } else {
             if(map.size() == capacity){
                 map.remove(tail.prev.key);
                 remove(tail.prev);
             }
             Node newNode = new Node(key, value);
             map.put(key, newNode);
             addToHead(newNode);
         }
    }
    
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
