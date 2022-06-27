class Solution {
    
    class Node {
        char ch;
        Node[] children;
        boolean isEnd;
        
        public Node(char ch){
            this.ch = ch;
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    
    Node root = new Node('0');
    Node curr = root;
    public boolean isPrefixString(String s, String[] words) {
        for(String word : words){
            insert(word);
        }
        
        curr = root;
        for(char ch : s.toCharArray()){
            if( curr.children[ch-'a'] == null ) return false;
            
            curr = curr.children[ch-'a'];
        }
        
        return curr.isEnd;
    }
    
    public void insert( String s){
        
        for(char ch : s.toCharArray()){
            if( curr.children[ch-'a'] == null ) curr.children[ch-'a'] = new Node(ch);
            
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
}