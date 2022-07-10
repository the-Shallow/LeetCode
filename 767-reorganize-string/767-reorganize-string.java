class Solution {
    
    class Node {
        char ch;
        int freq;
        
        public Node(char ch){
            this.ch = ch;
            this.freq = 0;
        }
    }
    
    
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>( (a,b) -> b.freq - a.freq );
        
        for(int i = 0;i<26;i++){
            if(freq[i]  > 0){
                // char curr = (char)('a' + i);
                Node newNode = new Node( (char)('a' + i) );
                newNode.freq = freq[i];
                queue.offer(newNode);
            }
        }
        
        Node prev = null;
        StringBuilder sb = new StringBuilder();
        
        while( !queue.isEmpty() ){
            Node curr = queue.poll();
            
            if(prev != null && prev.freq != 0){
                queue.offer(prev);
            }
            
            sb.append( curr.ch );
            curr.freq--;
            
            prev = curr;
        }
        
        
        return sb.toString().length() != s.length() ? "" : sb.toString();
    }
}