class WordFilter {
    
    class Node {
        char ch;
        Node[] children;
        int maxIndx;
        
        public Node(char ch){
            this.ch = ch;
            // 26 alphabet and { separator
            this.children = new Node[27];
            this.maxIndx = -1;
        }
    }

    Node root = new Node('/');
    public WordFilter(String[] words) {
        Node curr = root;
        
        for(int i = 0;i<words.length;i++){
            buildTrie( words[i] , i );
        } 
        
    }
    
    public void buildTrie( String word , int index   ){
        for(int i = 0;i<word.length();i++){
            build( word.substring(i) + "{" + word , index );
        }
    }
    
    public void build(String word , int index){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null ) curr.children[ch - 'a'] = new Node(ch);
            
            curr = curr.children[ch-'a'];
            curr.maxIndx = index;
        }
    }
    
    public int f(String prefix, String suffix) {
        return helper( suffix + "{" + prefix );
    }
    
    public int helper( String word  ){
        Node curr = root;
        
        for( char ch : word.toCharArray() ){
            if( curr.children[ch - 'a'] == null ) return -1;
            curr = curr.children[ch - 'a'];
        }
        
        return curr.maxIndx;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */