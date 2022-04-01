class Solution {
    class Node {
       
        boolean isEnd;
        Map<String,Node> children;
        
        public Node(){
          
            this.isEnd = false;
            this.children = new HashMap<>(); 
        }
    }
    
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        
        Node root = new Node();
        
        for( String fold : folder ){
            insert( fold , root );
        }
        
        for( String validString : root.children.keySet() ){
            helper( root.children.get(validString) , "/" + validString ,  res   );
        }
        
        return res;
    }
    
    public void helper( Node curr , String parent , List<String> temp ){
        if(curr.isEnd){
            temp.add(parent);
            return;
        }
        
        for( String validString : curr.children.keySet() ){
            helper( curr.children.get(validString) , parent + "/" + validString , temp );
        }
    }
    
    public void insert(String validString , Node curr){
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1;i<validString.length();i++){
            char ch = validString.charAt(i);
            
            if(ch != '/'){
                sb.append(ch);
            }else {
                curr.children.putIfAbsent( sb.toString() , new Node() );
                curr = curr.children.get(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        curr.children.putIfAbsent( sb.toString() , new Node() );
        curr = curr.children.get(sb.toString());
        curr.isEnd = true;
    }
    
   
}