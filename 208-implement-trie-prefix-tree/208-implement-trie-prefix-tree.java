class Trie {
    
    class Node {
        char ch;
        Node[] children;
        boolean isEnd;
        
        public Node(char ch){
            this.ch = ch;
            children = new Node[26];
            this.isEnd = false;
        }
    }
    
    Node root;
    public Trie() {
        root = new Node('0');
    }
    
    public void insert(String word) {
        Node curr = root;
        
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null) curr.children[ch-'a'] = new Node(ch);
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    
    public boolean search(String word) {
        Node curr = root;
        
        for(char ch : word.toCharArray()){
            if( curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }  
        
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch-'a'] == null) return false;
            
            curr = curr.children[ch-'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */