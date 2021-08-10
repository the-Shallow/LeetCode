class Solution {
    
    class CharacterCost {
        char ch;
        int cost;
        
        public CharacterCost(char ch , int cost){
            this.ch = ch;
            this.cost = cost;
        }
    }
    
    public int minCost(String s, int[] cost) {
        Stack<CharacterCost> stack = new Stack<>();
        int tcost = 0;
        for( int i = 0;i<s.length();i++ ){
            if( stack.size() > 0 && stack.peek().ch == s.charAt(i) ){
                CharacterCost item = stack.get(stack.size() - 1 );
                int itemCost = item.cost;
                if( itemCost > cost[i] ){
                    tcost+=cost[i];
                }else {
                    stack.pop();
                    stack.push( new CharacterCost(s.charAt(i),cost[i]) );
                    tcost+=itemCost;
                }
            }else {
                stack.push( new CharacterCost( s.charAt(i) , cost[i] ) );
            }
        }
        
        return tcost;
    }
}