class Solution {
    
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
    
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node('0');
        
        for( String word : dictionary ){
            insert( word , root );
        }
        
        StringBuilder sb =  new StringBuilder();
        
        String[] words = sentence.split(" ");
        
        for( String word : words ){
            sb.append( helper( word , root ) + " " );
        }
        
       
        return sb.toString().trim();
    }
    
    public String helper( String word , Node curr ){
        StringBuilder res = new StringBuilder();
        
        for(char ch : word.toCharArray()){
            if( curr.isEnd ) return res.toString();
            
            if( curr.children[ch - 'a'] == null ) return word;
            
            res.append(ch);
            curr = curr.children[ch - 'a'];
        }
        
        return word;
    }
    
    public void insert( String word , Node curr ){
        
        for( char ch : word.toCharArray() ){
            if( curr.children[ch - 'a'] == null ) curr.children[ch - 'a'] = new Node(ch);
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
}