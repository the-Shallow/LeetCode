class Solution {
    
    class Node {
        char ch;
        boolean isWord;
        Node[] children;
        
        public Node(char ch) {
            this.ch = ch;
            this.isWord = false;
            this.children = new Node[26];
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        
        Node root = new Node('\0');
        
        for( String product : products ){
            create( product , root );
        }
        
        String prefix = "";
        for( char ch : searchWord.toCharArray() ){
            prefix += ch;
            res.add( searchProducts( prefix , root ) );
        }
        
        return res;
    }
    
    public List<String> searchProducts(String prefix , Node curr){
        List<String> temp = new ArrayList<>();
        
        for(char ch : prefix.toCharArray()){
            if( curr.children[ch - 'a'] == null ) return temp;
            curr = curr.children[ch - 'a'];
        }
        
        helper( prefix , curr , temp );
        
        return temp;
    }
    
    public void helper(String prefix , Node curr , List<String> temp ){
        if(temp.size() == 3) return;
        
        if( curr.isWord ) temp.add( prefix );
        
        for(int i = 0;i<26;i++){
            if( curr.children[i] != null ){
                helper( prefix + curr.children[i].ch , curr.children[i]  , temp );
            }
        }
    }
    
    public void create( String word , Node root ){
        Node curr = root;
        
        for( char ch : word.toCharArray() ){
            if( curr.children[ch - 'a'] == null ) curr.children[ch - 'a'] = new Node(ch);
            
            curr = curr.children[ch - 'a'];
        }
        
        curr.isWord = true;
    }
}