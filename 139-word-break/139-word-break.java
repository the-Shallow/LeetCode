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
    Map<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        
        for(String word : wordDict) insert(word);
        
        return helper(s);
        
    }
    
    public boolean helper(String s){
        if( s.length() == 0 ) return true;
        
        if(map.containsKey(s) ) return map.get(s);
        
        for( int i = 0;i<s.length();i++ ){
            if( search( s.substring(0,i+1) ) && helper( s.substring(i+1) ) ){
                map.put(s,true);
                return true;
            }
        }
        
        
        map.put(s,false);
        return false;
    }
    
    public void insert( String word ){
        Node curr = root;
        
        for( char ch : word.toCharArray() ){
            if( curr.children[ch-'a'] == null ) curr.children[ch-'a'] = new Node(ch);
            
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    public boolean search(String word){
        Node curr = root;
        
        for(char ch : word.toCharArray() ){
            if( curr.children[ch-'a'] == null ) return false;
            
            curr = curr.children[ch-'a'];
        }
        
        return curr.isEnd;
    }
}