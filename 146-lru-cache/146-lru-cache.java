class LRUCache {
    class Node {
        int key;
        int value;
        Node left;
        Node right;
        
        public Node(int key , int value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    Node head = null;
    Node tail = null;
    HashMap<Integer,Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.head = new Node( -1,-1 );
        this.tail = new Node( -1 , -1);
        head.right = tail;
        tail.left = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if( !map.containsKey(key) ) return -1;
        Node curr = map.get(key);
        
        delete( curr );
        insertHead( new Node( key ,curr.value ) );
        
        return curr.value;
    }
    
    public void put(int key, int value) {
        
        if( map.containsKey(key) ){
            delete(map.get(key));
        }
        
        Node curr = new Node(key,value);

        if( map.size() >= capacity ){
            Node lru = tail.left;
            delete(lru);
        }

        insertHead(curr);
    }
    
    public void delete( Node deleteNode ){
        Node leftNode = deleteNode.left;
        Node rightNode = deleteNode.right;
        leftNode.right = rightNode;
        rightNode.left = leftNode;
        map.remove( deleteNode.key );
        deleteNode = null;
    }
    
    public void insertHead( Node newNode ){
        Node headNext = head.right;
        
        newNode.right = headNext;
        headNext.left = newNode;
        newNode.left = head;
        head.right = newNode;
        
        map.put( newNode.key , newNode );
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */