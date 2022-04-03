class WordDictionary {
    
    class Node {
        char ch;
        boolean isEnd;
        Node[] children;
        
        public Node(char ch){
            this.ch = ch;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }
    
    Node root = null;
    public WordDictionary() {
        root  = new Node('/');
    }
    
    public void addWord(String word) {
        Node curr = root;
        
        for( char ch : word.toCharArray() ){
            if( curr.children[ch - 'a'] == null ) curr.children[ch - 'a'] = new Node(ch);
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        boolean temp = helper( root , word );
        return temp;
    }
    
    public boolean helper(Node curr , String word){
    
       
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if( ch == '.' ){
                
                
                for( int j = 0;j<26;j++ ){
                    if( curr.children[j] != null ) {
                       boolean temp =  helper( curr.children[j] , word.substring( i+1 ) );
                        if(temp) return true;
                    }
                }
                
                return false;
                
            }else {
                if( curr.children[ch - 'a'] == null ) return false;
                curr = curr.children[ch - 'a'];
            }
        }
        
    
        return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */